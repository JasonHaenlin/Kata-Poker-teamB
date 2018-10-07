package poker.game;

import poker.game.exception.CardColorRuntimeException;

enum CardColor {
    // @formatter:off   
    HEART("Coeur"),
    CLOVER("Trefle"),
    SPADE("Pique"),
    SQUARE("Carre");
	// @formatter:on

    private String color = "";

    CardColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color;
    }

    public static CardColor getEnum(String strToEnum) {
        switch (strToEnum) {
        case "Tr":
            return CardColor.CLOVER;
        case "Co":
            return CardColor.HEART;
        case "Ca":
            return CardColor.SQUARE;
        case "Pi":
            return CardColor.SPADE;
        default:
            throw new CardColorRuntimeException(strToEnum);
        }
    }
}