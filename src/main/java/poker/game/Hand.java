package poker.game;

import java.util.ArrayList;
import java.util.List;

class Hand {

    private CombinationType type;
    private final int maxNumberOfCards = 5;
    private List<Card> hand;
    private int handNumber;

    private CardValue patternValue = null;
    private CardValue patternValueExtra = null;
    private CardColor patternColor = null;

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
            throw new RuntimeException("Erreur de saisie de la main: taille d'une main = 5 cartes");
        }
        hand = new ArrayList<>();
        for (String card : listCard) {
            Card nCard = new Card(extractValue(card), extractColor(card));
            if (hand.contains(nCard))
                throw new RuntimeException("Les doublons ne sont pas autorise dans la main " + nCard.toString());
            hand.add(nCard);
        }
        hand.sort((Card c1, Card c2) -> Integer.compare(c1.getIntValue(), c2.getIntValue()));
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
            throw new RuntimeException("mauvaise saisie de la main");
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

    private boolean check(List<String> listCard) {
        return listCard.size() == maxNumberOfCards;
    }

    /**
     * Check every cards of a hand to see if a pattern is found.
     *
     * @return the highest combition found
     */
    CombinationType checkHandType() {
        if (isFourOfAKindDetected()) {
            return CombinationType.FOUR_OF_A_KIND;
        } else if (isFullDetected()) {
            return CombinationType.FULL;
        } else if (isColorDetected()) {
            return CombinationType.COLOR;
        } else if (isStraight()) {
            return CombinationType.STRAIGHT;
        } else if (isThreeOfAKindDetected()) {
            return CombinationType.THREE_OF_A_KIND;
        } else if (isPairDetected()) {
            return CombinationType.PAIR;
        } else {
            return CombinationType.HIGHESTCARD;
        }
    }

    /**
     * If two cards of the same value are found we return that value. This method
     * doesn't check if a higher pattern is present.
     *
     * @return -1 if no pair has been found, return the value of the pair otherwise.
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
     * If tree cards of the same value are found we return that value. This method
     * doesn't check if a higher pattern is present.
     *
     * @return -1 if no tree of a kind has been found, return the value of the
     *         pattern otherwise.
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
     * If four cards of the same value are found we return that value. and sets the
     * patternValue to the value of the four of a kind
     * 
     * @return -1 if no four of a kind has been found, return the value of the
     *         pattern otherwise.
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
     * @return {-,-1} if no full has been found, return a tables with value of three
     *         of kind and value of pair
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
     * @return -1 if no straight has been found or return the highest value of the
     *         straight.
     */
    boolean isStraight() {
        int longueur = hand.size();
        Card max = hand.get(longueur - 1);
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

    /**
     * @return the type
     */
    CombinationType getType() {
        return this.type;
    }

    /**
     * Identify the pattern of the hand
     *
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

    private void setPatternResult(Card cardId) {
        this.patternColor = cardId.getColor();
        this.patternValue = cardId.getValue();
    }

    private void setPatternExtraCard(Card extraCard) {
        this.patternValueExtra = extraCard.getValue();
    }

}
