package poker.game;

import java.util.List;

public class Detection {

    CombinationType type1, type2;

    /**
     * Classe pour detecter les types de main
     */

    Detection()
    {
        this.type1 = CombinationType.HIGHESTCARD;
        this.type2 = CombinationType.HIGHESTCARD;
    }

    /**
     *
     * @param hand1
     * @param hand2
     */
    void detectionHand(Hand hand1, Hand hand2) {
        this.type1 = typeHand(hand1);
        this.type2 = typeHand(hand2);
    }

    CombinationType getType1()
    {
        return type1;
    }

    CombinationType getType2()
    {
        return type2;
    }
    /**
     * Detecte le type de la main entre Carree, Brelan, Pair et carte haute
     *
     * @param hand
     * @return
     */
    CombinationType typeHand(Hand hand) {
        if (findFourOfAKind(hand) != -1) {
            return CombinationType.FOUROFAKIND;
        } else if (findTriple(hand) != -1) {
            return CombinationType.TRIPLE;
        } else if (findPair(hand) != -1) {
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
    int findPair(Hand hand) {
        List<Card> handlist = hand.getHand();
        for (int i = 0; i < handlist.size() - 3; i++) {
            Card first = handlist.get(i);
            Card second = handlist.get(i + 1);
            Card third = handlist.get(i + 2);
            Card four = handlist.get(i + 3);
            if (first.equals(second) && !second.equals(third)) {
                return first.getValue();
            }
            if (!first.equals(second) && second.equals(third) && !third.equals(four)) {
                return second.getValue();
            }
            if (!second.equals(third) && third.equals(four)) {
                return third.getValue();
            }

        }
        return -1;
    }

    /**
     *
     * @param hand
     * @return La valeur de la carte qui forme le brelan si il y a un brelan dans
     *         hand sinon elle retourne -1.
     */
    int findTriple(Hand hand) {
        List<Card> handlist = hand.getHand();
        for (int i = 0; i < handlist.size() - 4; i++) {
            Card first = handlist.get(i);
            Card second = handlist.get(i + 1);
            Card third = handlist.get(i + 2);
            Card four = handlist.get(i + 3);
            Card five = handlist.get(i + 4);
            if (first.equals(second) && second.equals(third) && !third.equals(four)) {
                return first.getValue();
            }
            if (!first.equals(second) && second.equals(third) && third.equals(four) && !four.equals(five)) {
                return second.getValue();
            }
            if (!second.equals(third) && third.equals(four) && four.equals(five)) {
                return third.getValue();
            }

        }
        return -1;
    }

    /**
     *
     * @param hand
     * @return La valeur de la carte qui forme le carré si il y a un carré dans hand
     *         sinon elle retourne -1.
     */
    int findFourOfAKind(Hand hand) {
        List<Card> handlist = hand.getHand();
        for (int i = 0; i < handlist.size() - 4; i++) {
            Card first = handlist.get(i);
            Card second = handlist.get(i + 1);
            Card third = handlist.get(i + 2);
            Card four = handlist.get(i + 3);
            Card five = handlist.get(i + 4);
            if (first.equals(second) && second.equals(third) && third.equals(four) && !four.equals(five)) {
                return first.getValue();
            }
            if (!first.equals(second) && second.equals(third) && third.equals(four) && four.equals(five)) {
                return second.getValue();
            }

        }
        return -1;
    }

}
