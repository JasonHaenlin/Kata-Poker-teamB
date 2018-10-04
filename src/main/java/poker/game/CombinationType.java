package poker.game;

enum CombinationType {
	// @formatter:off
	HIGHESTCARD("Carte la plus haute "),
	PAIR("Paire de "),
	TWO_PAIR("Paire de "),
	THREE_OF_A_KIND("Triple de "),
	STRAIGHT("Suite au "),
	COLOR("couleur avec "),
	FULL("Full "), //TODO modifier pour brelan + paire ou autre
	FOUR_OF_A_KIND("Carre de "),
	QUINTE_FLUSH("Quinte flush de ");
	// @formatter:on

	private String typeOfHand = "";

	CombinationType(String typeOfHand) {
		this.typeOfHand = typeOfHand;
	}

	@Override
	public String toString() {
		return this.typeOfHand;
	}
}
