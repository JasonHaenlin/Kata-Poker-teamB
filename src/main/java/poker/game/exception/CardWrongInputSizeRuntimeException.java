package poker.game.exception;

/**
 * CardWrongInputSizeRuntimeException
 *
 * @author Ruben Houri
 * @author Maxime Castellano
 * @author Vincent Ung
 * @author Jason Haenlin
 */
public class CardWrongInputSizeRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardWrongInputSizeRuntimeException() {
        super("mauvaise saisie de la main : (ex: 5Tr ou RCa");
    }
}