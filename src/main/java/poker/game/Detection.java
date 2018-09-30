package poker.game;

import java.util.List;

class Detection {

    CombinationType type1, type2;

    /**
     * Classe pour detecter les types de main
     */

    Detection() {
        this.type1 = CombinationType.HIGHESTCARD;
        this.type2 = CombinationType.HIGHESTCARD;
    }

    /**
     *
     * @param hand1
     * @param hand2
     */
    void detectionHand(Hand hand1, Hand hand2) {
        this.type1 = typeHand(hand1.getHand());
        this.type2 = typeHand(hand2.getHand());
    }

    CombinationType getType1() {
        return type1;
    }

    CombinationType getType2() {
        return type2;
    }

    /**
     * Detecte le type de la main entre Carree, Brelan, Pair et carte haute
     *
     * @param hand
     * @return
     */
    CombinationType typeHand(List<Card> cards) {
        if (findFourOfAKind(cards) != -1) {
            return CombinationType.FOUROFAKIND;
        } else if (findTriple(cards) != -1) {
            return CombinationType.TRIPLE;
        } else if (findPair(cards) != -1) {
            return CombinationType.PAIR;
        } else {
            return CombinationType.HIGHESTCARD;
        }
    }

    /**
     *
     * @param hand
     * @return La valeur de la carte qui forme la pair si il y a une pair dans hand
     *         sinon elle retourne -1. En cas de double pair, retourne uniquement la
     *         pair la plus faible.
     */
    int findPair(List<Card> cards) {
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
     *
     * @param hand
     * @return La valeur de la carte qui forme le brelan si il y a un brelan dans
     *         hand sinon elle retourne -1.
     */
    int findTriple(List<Card> cards) {
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
     *
     * @param hand
     * @return La valeur de la carte qui forme le carré si il y a un carré dans hand
     *         sinon elle retourne -1.
     */
    int findFourOfAKind(List<Card> cards) {
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

}
