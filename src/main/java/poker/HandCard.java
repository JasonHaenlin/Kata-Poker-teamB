package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandCard {

    // Instantiate an arrayList of type Card
    private List<Card> hand = new ArrayList<>();

    /**
     * Default constructor
     */
    public HandCard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir une hand");
        int val = sc.nextInt();
        Card carte = new Card(val);
        hand.add(carte);
    }

    /**
     * @return the hand
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * retrieve the value of the higher card
     * 
     * @return
     */
    public int HandCardValue() {
        // retrieve the first element of the list
        List<Card> playerHand;
        Card HighCard;
        playerHand = this.getHand();
        HighCard = playerHand.get(0);
        return HighCard.getValue();

    }
}
