package poker.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class Game {

    public enum Player {
        FIRST, SECOND;
    }

    private List<Hand> player;
    private Referee referee;

    /**
     * create a poker game with 2 players
     */
    public Game() {
        this.player = new ArrayList<>();
        this.player.add(new Hand(Player.FIRST.ordinal()));
        this.player.add(new Hand(Player.SECOND.ordinal()));
        referee = new Referee();
    }

    /**
     * This method ask the user to enter a set of cards (5 cards no more, no less)
     * 
     * @param player
     */
    public void readNewEntry(Player player) {
        int numPlayer = player.ordinal();
        this.player.get(numPlayer).buildNewHand(readEntry(numPlayer + 1));
    }

    /**
     * print the result of the game after both hands has been <strong>computed and
     * identified</strong> to tell the winner
     */
    public void printTheResult() {
        referee.printResultOfTheGame();
    }

    /**
     * identidy the winner after both players hands has been check
     *
     */
    public void identifyTheWinner() {
        Hand firstPlayer = player.get(Player.FIRST.ordinal());
        Hand secondPlayer = player.get(Player.SECOND.ordinal());
        referee.establishTheWinner(firstPlayer, secondPlayer);
    }

    private ArrayList<String> readEntry(int player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur " + player + ": veuillez saisir une main");
        return new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
    }

    public void setEntryManualy() {
        this.player.get(1).buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Pi", "6Pi", "9Ca", "10Co")));
        this.player.get(0).buildNewHand(new ArrayList<>(Arrays.asList("3Tr", "5Co", "6Ca", "9Co", "10Tr")));
    }
}
