package poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    // Instantiate an arrayList of type Card
    private List<Card> hand;
    int handNumber;

    public Hand(int handNumber) {
        this.handNumber = handNumber;
    }

    /***
     * create a new hand of cards
     *
     * @return false if the entry is wrong, true otherwise
     */
    public boolean buildNewHand(List<String> listCard) {
        hand = new ArrayList<>();
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
    public List<Card> getHand() {
        return hand;
    }

    /**
     * @return the handNumber
     */
    public int getHandNumber() {
        return handNumber;
    }

    /**
     * retrieve the value of the higher card right now just the first value is
     * retrieve
     *
     * @return
     */
    public int handCardValue() {
        return this.getHand().get(0).getValue();
    }
}
