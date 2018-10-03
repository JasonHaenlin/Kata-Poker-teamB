package poker.game;

import java.util.List;

/**
 * This class provide a way to detect a pattern in the hand.
 */
class Detection {

    private CombinationType type1, type2;

    Detection() {
        this.type1 = CombinationType.HIGHESTCARD;
        this.type2 = CombinationType.HIGHESTCARD;
    }

    /**
     * Identify the pattern of the hands
     *
     * @param hand1
     * @param hand2
     */
    void detectHandsPatterns(Hand hand1, Hand hand2) {
        this.type1 = checkHandType(hand1.getHand());
        this.type2 = checkHandType(hand2.getHand());
    }

    /**
     * Check every cards of a hand to see if a pattern is found.
     *
     * @param cards
     * @return the highest combition found
     */
    CombinationType checkHandType(List<Card> cards) {
        if(isFullDetected(cards)[0] != -1) {
            return CombinationType.FULL;
        } else if (isFourOfAKindDetected(cards) != -1) {
            return CombinationType.FOUR_OF_A_KIND;
        } else if (isTreeOfAKindDetected(cards) != -1) {
            return CombinationType.TREE_OF_A_KIND;
        } else if (isPairDetected(cards) != -1) {
            return CombinationType.PAIR;
        } else {
            return CombinationType.HIGHESTCARD;
        }
    }

    /**
     * If two cards of the same value are found we return that value. This method
     * doesn't check if a higher pattern is present.
     *
     * @param hand
     * @return -1 if no pair has been found, return the value of the pair otherwise.
     */
    int isPairDetected(List<Card> cards) {
        Card prevCard = null;
        for (Card currCard : cards) {
            if (currCard.equals(prevCard)) {
                return currCard.getValue();
            }
            prevCard = currCard;
        }
        return -1;
    }

    /**
     * If tree cards of the same value are found we return that value. This method
     * doesn't check if a higher pattern is present.
     *
     * @param hand
     * @return -1 if no tree of a kind has been found, return the value of the
     * pattern otherwise.
     */
    int isTreeOfAKindDetected(List<Card> cards) {
        Card first = cards.get(0);
        Card second = cards.get(1);
        Card third = cards.get(2);
        Card fourth = cards.get(3);
        Card fifth = cards.get(4);
        if (first.equals(second) && second.equals(third) && !third.equals(fourth)) {
            return first.getValue();
        }
        if (!first.equals(second) && second.equals(third) && third.equals(fourth) && !fourth.equals(fifth)) {
            return second.getValue();
        }
        if (!second.equals(third) && third.equals(fourth) && fourth.equals(fifth)) {
            return third.getValue();
        }
        return -1;
    }

    /**
     * If four cards of the same value are found we return that value.
     *
     * @param hand
     * @return -1 if no four of a kind has been found, return the value of the
     * pattern otherwise.
     */
    int isFourOfAKindDetected(List<Card> cards) {
        Card first = cards.get(0);
        Card second = cards.get(1);
        Card third = cards.get(2);
        Card fourth = cards.get(3);
        Card fifth = cards.get(4);
        if (first.equals(second) && second.equals(third) && third.equals(fourth) && !fourth.equals(fifth)) {
            return first.getValue();
        }
        if (!first.equals(second) && second.equals(third) && third.equals(fourth) && fourth.equals(fifth)) {
            return second.getValue();
        }
        return -1;
    }

    /**
     *
     * @param cards
     * @return {-,-1} if no full has been found, return a tables with value of three of
     * kind and value of pair
     */
    int[] isFullDetected(List<Card> cards) {
        int tok = isTreeOfAKindDetected(cards);
        int full[] = {-1,-1};
        int val = 0;

        if (tok != -1) {
            for (int i = 0; i < 5; i++) {
                int valCard = cards.get(i).getValue();
                if (valCard != tok) {
                    if (val == 0) {
                        val = valCard;
                    } else if (val == valCard) {
                        full[0] = tok;
                        full[1] = val;
                    }
                }
            }
        }
        return full;
    }

    /**
     * @return the type1
     */
    CombinationType getType1() {
        return type1;
    }

    /**
     * @return the type2
     */
    CombinationType getType2() {
        return type2;
    }

}
