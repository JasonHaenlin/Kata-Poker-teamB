package poker.game.exception;

/**
 * CardValueRuntimeException
 *
 * @author Ruben Houri
 * @author Maxime Castellano
 * @author Vincent Ung
 * @author Jason Haenlin
 */
public class CardValueRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardValueRuntimeException(String value) {
        super("Valeur non reconnue : " + value);
    }

}