package poker.game;

enum CardColor {
    // @formatter:off   
    HEART("Coeur"),
    CLOVER("Trefle"),
    SPADE("Pique"),
    SQUARE("Carre");
	// @formatter:on

    private String cardColor = "";

    CardColor(String CardColor) {
        this.cardColor = CardColor;
    }

    @Override
    public String toString() {
        return this.cardColor;
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
            throw new RuntimeException("Couleur non reconnue");
        }
    }
}