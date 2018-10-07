package poker.game.exception;

/**
 * CardDuplicationBetweenPlayerRuntimeException
 */
public class CardDuplicationBetweenPlayerRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardDuplicationBetweenPlayerRuntimeException(String card) {
        super("Les doublons ne sont pas autorise entre deux mains :" + card);
    }

}