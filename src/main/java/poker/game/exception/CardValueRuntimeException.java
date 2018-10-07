package poker.game.exception;

/**
 * CardValueRuntimeException
 */
public class CardValueRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardValueRuntimeException(String value) {
        super("Valeur non reconnue : " + value);
    }

}