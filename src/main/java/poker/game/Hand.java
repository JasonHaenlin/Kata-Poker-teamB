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
}
