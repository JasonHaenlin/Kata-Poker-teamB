package poker;

import poker.game.Game;

/**
 * Poker
 */
public class Poker {

    public static void main(String[] args) {
        Game game = new Game();
        // game.readNewEntry(Player.FIRST);
        // game.readNewEntry(Player.SECOND);
        game.setEntryManualy();
        game.identifyTheWinner();
        game.printTheResult();
    }
}