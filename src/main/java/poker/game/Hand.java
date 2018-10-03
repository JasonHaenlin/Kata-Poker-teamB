package poker.game;

import java.util.ArrayList;
import java.util.List;

class Hand {

    private CombinationType type1, type2;
    private final int maxNumberOfCards = 5;
    private List<Card> hand;
    private int handNumber;

    Hand(int handNumber) {
        this.handNumber = handNumber;
        this.type1 = CombinationType.HIGHESTCARD;
        this.type2 = CombinationType.HIGHESTCARD;
    }

    /**
     * create a new hand of cards
     *
     * @return false if the entry is wrong, true otherwise
     * @throws Exception
     * @throws NumberFormatException
     */
    void buildNewHand(List<String> listCard) {
        if (!check(listCard)) {
            throw new RuntimeException("Erreur de saisie de la main: taille d'une main = 5 cartes");
        }
        hand = new ArrayList<>();
        for (String card : listCard) {
            hand.add(new Card(Integer.parseInt(card)));
        }
        hand.sort((Card c1, Card c2) -> Integer.compare(c1.getValue(), c2.getValue()));
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
     * @param cards
     * @return the highest combition found
     */
    CombinationType checkHandType(List<Card> cards) {
        if (isFullDetected(cards)[0] != -1) {
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
     * @param cards
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
     * @param cards
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
     * @param cards
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
     * @param cards
     * @return {-,-1} if no full has been found, return a tables with value of three of
     * kind and value of pair
     */
    int[] isFullDetected(List<Card> cards) {
        int tok = isTreeOfAKindDetected(cards);
        int full[] = {-1, -1};
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
     * @param cards
     * @return -1 if no straight has been found or return the highest value of the straight.
     */
    int isStraight(List<Card> cards) {


        int longueur = cards.size();
        Card max = cards.get(longueur - 1);
        int i = 0;

        while (cards.get(i + 1).getValue() - cards.get(i).getValue() == 1) {

            if (cards.get(i + 1).getValue() - max.getValue() == 0) {
                return max.getValue();
            }
            i++;

        }

        i = 0;

        if (max.getValue() - cards.get(i).getValue() == 12) {
            while (cards.get(i + 1).getValue() - cards.get(i).getValue() == 1) {
                if (cards.get(i + 1).getValue() - 5 == 0) {
                    return 5;
                }
                i++;
            }
        }
        return -1;

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

    /**
     * Identify the pattern of the hand
     *
     * @param hand
     */
    void detectHandPatterns(Hand hand) {
        this.type1 = checkHandType(hand.getHand());
    }
}
