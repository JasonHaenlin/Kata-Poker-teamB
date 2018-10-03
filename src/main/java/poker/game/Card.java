package poker.game;

class Card {

    private CardValue value;
    private CardColor color;

    /**
     * 
     * @param value
     * @param color
     */
    Card(CardValue value, CardColor color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public int hashCode() {
        return this.value.getValue();
    }

    /**
     * check if they are both cards with the same value
     * 
     * @param obj
     * @return true if they are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        return this.value == card.value;
    }

    /**
     * @return the value
     */
    int getValue() {
        return value.getValue();
    }

    /**
     * @return the color
     */
    public CardColor getColor() {
        return color;
    }
}
