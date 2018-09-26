package poker;

class Card {

    private int value;

    /**
     * entry between 2 and 14 (error otherwise)
     * 
     * @param value
     * @throws Exception
     */
    Card(int value) throws Exception {
        this.value = value;
        if (!this.isCardCorrect()) {
            throw new Exception("Erreur lors de la saisie");
        }
    }

    /**
     * @return the value
     */
    int getValue() {
        return value;
    }

    /**
     * isCardCorrrect if the entry is correct
     * 
     * @return true if it's correct, false otherwise
     */
    boolean isCardCorrect() {
        return 2 <= this.value && this.value <= 14;
    }

    @Override
    public int hashCode() {
        return this.value;
    }

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
}
