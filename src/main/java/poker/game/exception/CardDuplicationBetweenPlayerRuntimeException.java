package poker.game.exception;

/**
 * CardDuplicationBetweenPlayerRuntimeException
 *
 * @author Ruben Houri
 * @author Maxime Castellano
 * @author Vincent Ung
 * @author Jason Haenlin
 */
public class CardDuplicationBetweenPlayerRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardDuplicationBetweenPlayerRuntimeException(String card) {
        super("Les doublons ne sont pas autorise entre deux mains :" + card);
    }

}