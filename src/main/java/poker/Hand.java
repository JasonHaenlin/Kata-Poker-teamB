package poker;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class Hand {

    // Instantiate an arrayList of type Card
    private SortedSet<Card> hand;
    int handNumber;

    Hand(int handNumber) {
        this.handNumber = handNumber;
    }

    /***
     * create a new hand of cards
     *
     * @return false if the entry is wrong, true otherwise
     */
    boolean buildNewHand(List<String> listCard) {
        if(!check(listCard)){
            System.out.println("Nombre incorrect de carte :");
            return false;
        }
        hand = new TreeSet<>((Card c1, Card c2) -> Integer.compare(c1.getValue(), c2.getValue()));
        for (String card : listCard) {
            try {
                hand.add(new Card(Integer.parseInt(card)));
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }
        return true;

    }

    /**
     * @return the hand
     */
    SortedSet<Card> getHand() {
        return hand;
    }

    /**
     * @return the handNumber
     */
    int getHandNumber() {
        return handNumber;
    }

    /**
     * retrieve the value of the higher card right now just the first value is
     * retrieve
     *
     * @return
     */
    int handCardHightestValue() {
        return this.getHand().last().getValue();
    }

    boolean check(List<String> listCard) {
        return listCard.size() ==5;

    }
}