package poker.game;

enum CombinationType {
	// @formatter:off
	HIGHESTCARD(1,"Carte la plus haute "),
	PAIR(10,"Paire de "),
	TWO_PAIR(100,"Double Paire de "),
	THREE_OF_A_KIND(1000,"Triple de "),
	STRAIGHT(10000,"Suite au "),
	COLOR(11000,"couleur avec "),
	FULL(12000,"Full "),
	FOUR_OF_A_KIND(13000,"Carre de "),
	QUINTE_FLUSH(200000,"Quinte flush de "),
	ROYAL_QUINTE_FLUSH(210000,"Quinte flush Royal ");
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
