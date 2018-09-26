package poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

class Hand {

    // Instantiate an arrayList of type Card
    private List<Card> hand;
    int handNumber;

    Hand(int handNumber) {
        this.handNumber = handNumber;
    }

    /**
     * create a new hand of cards
     *
     * @return false if the entry is wrong, true otherwise
     */
    boolean buildNewHand(List<String> listCard) {
        if (!check(listCard)) {
            System.out.println("Nombre incorrect de carte :");
            return false;
        }
        hand = new ArrayList<>();
        for (String card : listCard) {
            try {
                hand.add(new Card(Integer.parseInt(card)));
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }
        hand.sort((Card c1, Card c2) -> Integer.compare(c1.getValue(), c2.getValue()));
        return true;

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

    boolean check(List<String> listCard) {
        return listCard.size() == 5;

    }

    public int scoring() {

        int score = 0;
        Map<Integer, Integer> HandOccuration = new HashMap<>();

        for (Card card : hand) {
            int hs = card.getValue();

            if (HandOccuration.containsKey(hs)) {
                HandOccuration.put(hs, HandOccuration.get(hs) + 1);
            } else {
                HandOccuration.put(hs, 1);
            }

            switch (HandOccuration.get(hs)) {
            case 2:
                score = 100 + hs;
                break;
            case 3:
                score = 1000 + hs;
                break;
            case 4:
                score = 10000 + hs;
                break;
            }
        }
        return score;
    }
}
