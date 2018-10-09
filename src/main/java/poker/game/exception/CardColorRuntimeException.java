package poker.game.exception;

/**
 * CardColorRuntimeException
 *
 * @author Ruben Houri
 * @author Maxime Castellano
 * @author Vincent Ung
 * @author Jason Haenlin
 */
public class CardColorRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardColorRuntimeException(String color) {
        super("Couleur non reconnue : " + color);
    }

}