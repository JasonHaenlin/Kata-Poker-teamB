package poker;

import poker.game.Game;
import poker.game.Game.Player;

/**
 * Poker
 */
public class Poker {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.readNewEntry(Player.FIRST);
        game.readNewEntry(Player.SECOND);
        game.computeTheHands();
        game.identifyTheWinner();
        game.printTheResult();
    }
}