package poker.game;

/**
 * <p>
 * Card object used to build a new Card
 * </p>
 * <p>
 * Each card need a color from <strong>CardColor</strong> and a value from
 * <strong>CardValue</strong>
 * </p>
 * 
 * @author Ruben Houri
 * @author Maxime Castellano
 * @author Vincent Ung
 * @author Jason Haenlin
 * @see CardColor
 * @see CardValue
 */

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
        return this.value == card.value && this.color == card.color;
    }

    boolean equalsValue(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        return this.value == card.value;
    }

    boolean equalsColor(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        return this.color == card.color;
    }

    /**
     * @return the value
     */
    CardValue getValue() {
        return value;
    }

    int getIntValue() {
        return value.getValue();
    }

    /**
     * @return the color
     */
    CardColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "[value: " + this.value.toString() + ", color: " + this.color.toString() + "]";
    }
}
