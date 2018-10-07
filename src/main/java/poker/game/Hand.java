package poker.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import poker.game.exception.CardDuplicationInHandRuntimeException;
import poker.game.exception.CardWrongInputSizeRuntimeException;
import poker.game.exception.WrongHandSizeRuntimeException;

class Hand {

    private CombinationType type;
    private final int maxNumberOfCards = 5;
    private List<Card> hand;
    private int handNumber;

    private CardValue patternValue = CardValue.C_2;
    private CardValue patternValueExtra = CardValue.C_2;
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
        hand = new ArrayList<>();
        for (String card : listCard) {
            Card nCard = new Card(extractValue(card), extractColor(card));
            if (hand.contains(nCard))
                throw new CardDuplicationInHandRuntimeException(card.toString());
            hand.add(nCard);
        }
        hand.sort((Card c1, Card c2) -> Integer.compare(c1.getIntValue(), c2.getIntValue()));
    }

    /**
     * Check every cards of a hand to see if a pattern is found.
     *
     * @return the highest combition found
     */
    CombinationType checkHandType() {
        if (!advancePatternEnabled) {
            popAndUpdateHighestCard();
            return CombinationType.HIGHESTCARD;
        }
        if (isFourOfAKindDetected()) {
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
        for (Card currCard : hand) {
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
        Card first = hand.get(0);
        Card second = hand.get(1);
        Card third = hand.get(2);
        Card fourth = hand.get(3);
        Card fifth = hand.get(4);
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
        Card first = hand.get(0);
        Card second = hand.get(1);
        Card third = hand.get(2);
        Card fourth = hand.get(3);
        Card fifth = hand.get(4);
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
        List<Card> clone = hand;
        hand = hand.stream().filter(c -> c.getValue() != getPatternValue()).collect(Collectors.toList());
        boolean ok = isPairDetected();
        hand = clone;
        if (ok && getPatternValue() != getPatternValueExtra()) {
            return true;
        }
        return false;
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
                int valCard = hand.get(i).getIntValue();
                if (valCard != tok) {
                    if (val == 0) {
                        val = valCard;
                    } else if (val == valCard) {
                        setPatternExtraCard(hand.get(i));
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
        Card max = hand.get(hand.size() - 1);
        int i = 0;
        while (hand.get(i + 1).getIntValue() - hand.get(i).getIntValue() == 1) {

            if (hand.get(i + 1).getIntValue() - max.getIntValue() == 0) {
                setPatternResult(max);
                return true;
            }
            i++;
        }
        i = 0;
        if (max.getIntValue() - hand.get(i).getIntValue() == 12) {
            while (hand.get(i + 1).getIntValue() - hand.get(i).getIntValue() == 1) {
                if (hand.get(i + 1).getIntValue() - 5 == 0) {
                    setPatternResult(hand.get(i + 1));
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
        for (Card currCard : hand) {
            if (!currCard.equalsColor(prev) && prev != null) {
                return false;
            }
            prev = currCard;
        }
        setPatternResult(prev);
        return true;
    }

    void popAndUpdateHighestCard() {
        setPatternResult(hand.remove(hand.size() - 1));
        setPatternExtraCard(null);
        type = CombinationType.HIGHESTCARD;
    }

    private void setPatternResult(Card cardId) {
        this.patternColor = cardId.getColor();
        this.patternValue = cardId.getValue();
    }

    private void setPatternExtraCard(Card extraCard) {
        if (extraCard == null) {
            this.patternValueExtra = CardValue.C_2;
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
        return listCard.size() == maxNumberOfCards;
    }

    void removeAdvancedPatterns() {
        this.advancePatternEnabled = false;
    }

    boolean isEmpty() {
        return this.hand.isEmpty();
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
    CombinationType getHandPattern() {
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
        return hand;
    }

    /**
     * @return the handNumber
     */
    int getHandNumber() {
        return handNumber;
    }

}
