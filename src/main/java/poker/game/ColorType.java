package poker.game;

enum ColorType {
    // @formatter:off   
    HEART("Coeur"),
    CLOVER("Trefle"),
    SPADE("Pique"),
    SQUARE("Carre");
	// @formatter:on

    private String cardColor = "";

    ColorType(String cardColor) {
        this.cardColor = cardColor;
    }

    @Override
    public String toString() {
        return this.cardColor;
    }

    public String getAcronym() {
        return this.cardColor.substring(0, 1);
    }

    public static ColorType getEnum(String strToEnum) {
        switch (strToEnum) {
        case "Tr":
            return ColorType.CLOVER;
        case "Co":
            return ColorType.HEART;
        case "Ca":
            return ColorType.SQUARE;
        case "Pi":
            return ColorType.SPADE;
        default:
            throw new RuntimeException("Couleur non reconnue");
        }
    }
}