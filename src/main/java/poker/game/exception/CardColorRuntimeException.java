package poker.game.exception;

/**
 * CardColorRuntimeException
 */
public class CardColorRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardColorRuntimeException(String color) {
        super("Couleur non reconnue : " + color);
    }

}