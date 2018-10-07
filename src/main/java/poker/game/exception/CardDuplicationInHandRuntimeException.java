package poker.game.exception;

/**
 * CardDuplicationInHandRuntimeException
 */
public class CardDuplicationInHandRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardDuplicationInHandRuntimeException(String card) {
        super("Les doublons ne sont pas autorise dans la main : " + card);
    }

}