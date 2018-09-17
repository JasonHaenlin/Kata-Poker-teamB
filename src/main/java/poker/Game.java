package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        List<Hand> player = new ArrayList<>();
        player.add(new Hand(1));
        player.add(new Hand(2));
        Referee Referee = new Referee();

        for (Hand hand : player) {
            while (!hand.buildNewHand(readEntry(hand.getHandNumber())))
                ;
        }

        // <temporary!!>
        Card cardInHand1 = player.get(0).getHand().get(0);
        Card cardInHand2 = player.get(1).getHand().get(0);

        Referee.winner(cardInHand1,cardInHand2);
        // </temporary!!>


    }

    public static int readEntry(int player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur " + player + ": veillez saisir une main");
        return sc.nextInt();
    }
}
