package poker.game;

/**
 * <p>
 * This class list all the possible combination with a coefficient to compute
 * the score regarding the pattern
 * </p>
 * <p>
 * A string is given to print the details of a game
 * </p>
 * 
 * @author Ruben Houri
 * @author Maxime Castellano
 * @author Vincent Ung
 * @author Jason Haenlin
 */

enum CombinationType {
	// @formatter:off
	HIGHESTCARD(1,"carte la plus élevée : "),
	PAIR(10,"paire de "),
	TWO_PAIR(100,"double paire de "),
	THREE_OF_A_KIND(1000,"triple de "),
	STRAIGHT(3100,"suite au(x) "),
	COLOR(6800,"couleur de "),
	FULL(42000,"full de "),
	FOUR_OF_A_KIND(330000,"carre de "),
	QUINTE_FLUSH(925000,"quinte flush de ");
	// @formatter:on

	private String typeOfHand = "";
	private int strength = 0;

	CombinationType(int strength, String typeOfHand) {
		this.typeOfHand = typeOfHand;
		this.strength = strength;
	}

	@Override
	public String toString() {
		return this.typeOfHand;
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}
}
