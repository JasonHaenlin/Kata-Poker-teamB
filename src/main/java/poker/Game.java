package poker;

import java.util.ArrayList;
import java.util.Arrays;
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
        Hand hand1 = player.get(0);
        Hand hand2 = player.get(1);

        Referee.winner(hand1, hand2);
        // </temporary!!>

    }

    public static ArrayList<String> readEntry(int player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur " + player + ": veuillez saisir une main");
        return new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
    }
}
