package poker;

import poker.game.Game;
import poker.game.Game.Player;

/**
 * 
 * 
 * @author Ruben Houri
 * @author Maxime Castellano
 * @author Vincent Ung
 * @author Jason Haenlin
 * @see Game
 */

public class Poker {

    public static void main(String[] args) {
        Game game = new Game();
        game.readNewEntry(Player.FIRST);
        game.readNewEntry(Player.SECOND);
        game.identifyTheWinner();
        game.printTheResult();
    }
}