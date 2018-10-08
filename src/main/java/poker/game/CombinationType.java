package poker.game;

enum CombinationType {
	// @formatter:off
	HIGHESTCARD(1,"Carte la plus haute "),
	PAIR(10,"Paire de "),
	TWO_PAIR(100,"Double Paire de "),
	THREE_OF_A_KIND(1000,"Triple de "),
	STRAIGHT(2900,"Suite au "),
	COLOR(6800,"couleur avec "),
	FULL(42000,"Full "),
	FOUR_OF_A_KIND(330000,"Carre de "),
	QUINTE_FLUSH(925000,"Quinte flush de ");
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
