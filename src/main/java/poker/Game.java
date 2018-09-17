package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        List<Hand> player = new ArrayList<>();
        player.add(new Hand(1));
        player.add(new Hand(2));

        for (Hand hand : player) {
            while (!hand.buildNewHand(readEntry(hand.getHandNumber())))
                ;
        }

        // <temporary!!>
        int main1 = player.get(0).getHand().get(0).getValue();
        int main2 = player.get(1).getHand().get(0).getValue();

        if (2 <= main1 && main1 <= 14 && 2 <= main2 && main2 <= 14) {
            if (main1 < main2) {
                System.out.println("La main N°2 est meilleur");
            } else if (main1 > main2) {
                System.out.println("La main N°1 est meilleur");
            } else {
                System.out.println(" Egalité !");
            }
        } else {
            System.out.println("Une des mains est impossible !");
        }
        // </temporary!!>
    }

    public static int readEntry(int player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur " + player + ": veillez saisir une main");
        return sc.nextInt();
    }
}
