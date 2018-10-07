package poker.game.exception;

/**
 * WrongHandSizeRuntimeException
 */
public class WrongHandSizeRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public WrongHandSizeRuntimeException() {
        super("Erreur de saisie de la main: taille d'une main = 5 cartes");
    }

}