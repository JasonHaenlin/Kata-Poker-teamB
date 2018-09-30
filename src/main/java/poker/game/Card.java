package poker.game;

class Card {

    private int value;

    /**
     * entry between 2 and 14 (error otherwise)
     * 
     * @param value
     * @throws Exception
     */
    Card(int value) {
        this.value = value;
        if (!this.isCardCorrect()) {
            throw new RuntimeException("Erreur lors de la saisie d'une ou plusieurs cartes");
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
    private boolean isCardCorrect() {
        return 2 <= this.value && this.value <= 14;
    }

    @Override
    public int hashCode() {
        return this.value;
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
}
