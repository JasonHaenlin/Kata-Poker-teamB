package poker.game;

enum CombinationType {
	// @formatter:off
	HIGHESTCARD(1,"Carte la plus haute "),
	PAIR(2,"Paire de "),
	TWO_PAIR(3,"Double Paire de "),
	THREE_OF_A_KIND(4,"Triple de "),
	STRAIGHT(5,"Suite au "),
	COLOR(6,"couleur avec "),
	FULL(7,"Full "),
	FOUR_OF_A_KIND(8,"Carre de "),
	QUINTE_FLUSH(9,"Quinte flush de "),
	ROYAL_QUINTE_FLUSH(10,"Quinte flush Royal ");
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
