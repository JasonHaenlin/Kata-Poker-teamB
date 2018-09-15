package poker;

public class Card {

    private int value;

    /**
     * default constructor
     */
    public Card() {
        this.value = 0;
    }

    /**
     * override constructor
     * 
     * @param value
     */
    public Card(int value) {
        this.value = value;
        if (!this.Check()) {
            System.out.println("Erreur lors de la saisie");
            System.out.println("Veuillez ressaisir la main ");
            value = 0;
        }
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Check if the entry is correct
     * 
     * @return true if it's correct, false otherwise
     */
    public boolean Check() {
        return this.value < 2 || this.value < 14;
    }
}
