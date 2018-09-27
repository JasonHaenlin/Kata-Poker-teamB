package poker.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class Game {

    /**
     * 
     */
    public enum Player {
        FIRST, SECOND;
    }

    private List<Hand> player;
    private Referee referee;

    /**
     * 
     */
    public Game() {
        this.player = new ArrayList<>();
        this.player.add(new Hand(Player.FIRST.ordinal()));
        this.player.add(new Hand(Player.SECOND.ordinal()));
        referee = new Referee();
    }

    /**
     * 
     * @param player
     * @throws NumberFormatException
     * @throws Exception
     */
    public void readNewEntry(Player player) {
        int numPlayer = player.ordinal();
        this.player.get(numPlayer).buildNewHand(readEntry(numPlayer));
    }

    /**
     * 
     * @param first
     * @param second
     */
    public void printTheResult() {
        referee.printResultOfTheGame();
    }

    /**
     * 
     * @param first
     * @param second
     */
    public void identifyTheWinner() {
        referee.establishTheWinner();
    }

    /**
     * 
     * @param first
     * @param second
     */
    public void computeTheHands() {
        Hand firstPlayer = player.get(Player.FIRST.ordinal());
        Hand secondPlayer = player.get(Player.FIRST.ordinal());
        referee.checkHandsCombination(firstPlayer, secondPlayer);
    }

    private ArrayList<String> readEntry(int player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur " + player + ": veuillez saisir une main");
        return new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
    }
}
