package poker.game;

import java.util.ArrayList;
import java.util.List;

class Hand {

    private final int maxNumberOfCards = 5;
    private List<Card> hand;
    private int handNumber;

    Hand(int handNumber) {
        this.handNumber = handNumber;
    }

    /**
     * create a new hand of cards
     *
     * @return false if the entry is wrong, true otherwise
     * @throws Exception
     * @throws NumberFormatException
     */
    void buildNewHand(List<String> listCard) throws Exception {
        if (!check(listCard)) {
            System.out.println("Nombre incorrect de carte :");
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

    /**
     * retrieve the value of the higher card right now just the first value is
     * retrieve
     *
     * @return
     */
    int handCardHightestValue() {
        return this.hand.get(this.hand.size() - 1).getValue();
    }

    private boolean check(List<String> listCard) {
        return listCard.size() == maxNumberOfCards;

    }
}
