package poker.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import poker.game.exception.CardDuplicationInHandRuntimeException;
import poker.game.exception.CardWrongInputSizeRuntimeException;
import poker.game.exception.WrongHandSizeRuntimeException;

class Hand {

    private static final int HAND_SIZE = 5;

    private CombinationType type;
    private List<Card> cardInHand;
    private int handNumber;

    private CardValue patternValue = CardValue.C_2;
    private CardValue patternValueExtra = null;
    private CardColor patternColor = null;
    private boolean advancePatternEnabled = true;

    Hand(int handNumber) {
        this.handNumber = handNumber;
        this.type = CombinationType.HIGHESTCARD;
    }

    /**
     * create a new hand of cards
     *
     * @throws Exception
     */
    void buildNewHand(List<String> listCard) {
        if (!check(listCard)) {
            throw new WrongHandSizeRuntimeException();
        }
        cardInHand = new ArrayList<>();
        for (String card : listCard) {
            Card nCard = new Card(extractValue(card), extractColor(card));
            if (cardInHand.contains(nCard))
                throw new CardDuplicationInHandRuntimeException(nCard.toString());
            cardInHand.add(nCard);
        }
        cardInHand.sort((Card c1, Card c2) -> Integer.compare(c1.getIntValue(), c2.getIntValue()));
    }

    /**
     * Check every cards of a hand to see if a pattern is found.
     *
     * @return the highest combition found
     */
    CombinationType checkHandType() {
        patternValueExtra = null;
        if (!advancePatternEnabled) {
            popAndUpdateHighestCard();
            return CombinationType.HIGHESTCARD;
        }
        if (isQuinteFlushDetected()) {
            return CombinationType.QUINTE_FLUSH;
        } else if (isFourOfAKindDetected()) {
            return CombinationType.FOUR_OF_A_KIND;
        } else if (isFullDetected()) {
            return CombinationType.FULL;
        } else if (isDoublePairDetected()) {
            return CombinationType.TWO_PAIR;
        } else if (isColorDetected()) {
            return CombinationType.COLOR;
        } else if (isStraight()) {
            return CombinationType.STRAIGHT;
        } else if (isThreeOfAKindDetected()) {
            return CombinationType.THREE_OF_A_KIND;
        } else if (isPairDetected()) {
            return CombinationType.PAIR;
        } else {
            removeAdvancedPatterns();
            popAndUpdateHighestCard();
            return CombinationType.HIGHESTCARD;
        }
    }

    /**
     * If two cards of the same value patternValue get this value. This method
     * doesn't check if a higher pattern is present.
     *
     * @return True if this hand contain a pair.
     */
    boolean isPairDetected() {
        Card prevCard = null;
        for (Card currCard : cardInHand) {
            if (currCard.equalsValue(prevCard)) {
                setPatternResult(currCard);
                return true;
            }
            prevCard = currCard;
        }
        return false;
    }

    /**
     * If tree cards of the same value patternValue is this value. This method don't
     * check if the hand contain Four of Kind
     *
     * @return true is the hand is Three Of Kind.
     */
    boolean isThreeOfAKindDetected() {
        Card first = cardInHand.get(0);
        Card second = cardInHand.get(1);
        Card third = cardInHand.get(2);
        Card fourth = cardInHand.get(3);
        Card fifth = cardInHand.get(4);
        if (first.equalsValue(second) && second.equalsValue(third) && !third.equalsValue(fourth)) {
            setPatternResult(first);
            return true;
        }
        if (!first.equalsValue(second) && second.equalsValue(third) && third.equalsValue(fourth) && !fourth.equalsValue(fifth)) {
            setPatternResult(second);
            return true;
        }
        if (!second.equalsValue(third) && third.equalsValue(fourth) && fourth.equalsValue(fifth)) {
            setPatternResult(third);
            return true;
        }
        return false;
    }

    /**
     * If the hand is FourOfKind, PatternValue is the value of FourOfKind
     *
     * @return true if hand is FourOfKind.
     */
    boolean isFourOfAKindDetected() {
        Card first = cardInHand.get(0);
        Card second = cardInHand.get(1);
        Card third = cardInHand.get(2);
        Card fourth = cardInHand.get(3);
        Card fifth = cardInHand.get(4);
        if (first.equalsValue(second) && second.equalsValue(third) && third.equalsValue(fourth) && !fourth.equalsValue(fifth)) {
            setPatternResult(first);
            return true;
        }
        if (!first.equalsValue(second) && second.equalsValue(third) && third.equalsValue(fourth) && fourth.equalsValue(fifth)) {
            setPatternResult(second);
            return true;
        }
        return false;
    }

    /**
     * If the hand is double pair, patternValue is the smallest value of pair and
     * patternValueExtra is the biggest value
     *
     * @return True if hand type is double pair false else
     */
    boolean isDoublePairDetected() {
        if (!isPairDetected()) {
            return false;
        }
        setPatternExtraCard(new Card(getPatternValue(), getPatternColor()));
        List<Card> clone = cardInHand;
        cardInHand = cardInHand.stream().filter(c -> c.getValue() != getPatternValue()).collect(Collectors.toList());
        boolean ok = isPairDetected();
        cardInHand = clone;
        return (ok && getPatternValue() != getPatternValueExtra());
    }

    /**
     * If the hand is double pair, patternValue is the value of three of kind and
     * patternValueExtra is the pair value
     * 
     * @return True if hand type is full false else
     */
    boolean isFullDetected() {
        if (!isThreeOfAKindDetected())
            return false;
        int val = 0;
        int tok = getPatternValue().getValue();
        if (tok != -1) {
            for (int i = 0; i < 5; i++) {
                int valCard = cardInHand.get(i).getIntValue();
                if (valCard != tok) {
                    if (val == 0) {
                        val = valCard;
                    } else if (val == valCard) {
                        setPatternExtraCard(cardInHand.get(i));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @return true if the hand is straight false else.
     */
    boolean isStraight() {
        Card max = cardInHand.get(cardInHand.size() - 1);
        int i = 0;
        while (cardInHand.get(i + 1).getIntValue() - cardInHand.get(i).getIntValue() == 1) {

            if (cardInHand.get(i + 1).getIntValue() - max.getIntValue() == 0 && cardInHand.get(3).equals(cardInHand.get(i))) {
                setPatternResult(max);
                return true;
            }
            i++;
        }
        i = 0;
        if (max.getIntValue() - cardInHand.get(i).getIntValue() == 12) {
            while (cardInHand.get(i + 1).getIntValue() - cardInHand.get(i).getIntValue() == 1) {
                if (cardInHand.get(i + 1).getIntValue() - 5 == 0) {
                    setPatternResult(cardInHand.get(i + 1));
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    /**
     *
     * @return true if the hand is color false else
     */

    boolean isColorDetected() {
        Card prev = null;
        for (Card currCard : cardInHand) {
            if (!currCard.equalsColor(prev) && prev != null) {
                return false;
            }
            prev = currCard;
        }
        if (prev != null)
            setPatternResult(prev);
        return true;
    }

    boolean isQuinteFlushDetected() {
        return isColorDetected() && isStraight();
    }

    void popAndUpdateHighestCard() {
        setPatternResult(cardInHand.remove(cardInHand.size() - 1));
        setPatternExtraCard(null);
        type = CombinationType.HIGHESTCARD;
    }

    private void setPatternResult(Card cardId) {
        this.patternColor = cardId.getColor();
        this.patternValue = cardId.getValue();
    }

    private void setPatternExtraCard(Card extraCard) {
        if (extraCard == null) {
            this.patternValueExtra = null;
        } else {
            this.patternValueExtra = extraCard.getValue();
        }
    }

    private CardColor extractColor(String card) {
        checkSize(card);
        return CardColor.getEnum(card.substring(card.length() - 2));
    }

    private CardValue extractValue(String card) {
        checkSize(card);
        return CardValue.getEnum(card.substring(0, card.length() - 2));
    }

    private void checkSize(String card) {
        if (card.length() < 3)
            throw new CardWrongInputSizeRuntimeException();
    }

    private boolean check(List<String> listCard) {
        return listCard.size() == HAND_SIZE;
    }

    void removeAdvancedPatterns() {
        this.advancePatternEnabled = false;
    }

    boolean isEmpty() {
        return this.cardInHand.isEmpty();
    }

    /**
     * @return the type
     */
    CombinationType getType() {
        return this.type;
    }

    /**
     * Identify the pattern of the hand
     */
    CombinationType computeHandPattern() {
        this.type = checkHandType();
        return this.type;
    }

    /**
     * @return the patternColor
     */
    CardColor getPatternColor() {
        return patternColor;
    }

    /**
     * @return the patternValue
     */
    CardValue getPatternValue() {
        return patternValue;
    }

    /**
     * @return the patternValueExtra
     */
    CardValue getPatternValueExtra() {
        return patternValueExtra;
    }

    /**
     * @return the hand
     */
    List<Card> getHand() {
        return cardInHand;
    }

    /**
     * @return the handNumber
     */
    int getHandNumber() {
        return handNumber;
    }

}
