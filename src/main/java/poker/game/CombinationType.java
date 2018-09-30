package poker.game;

enum CombinationType {
	// @formatter:off
	HIGHESTCARD("Carte la plus haute"),
	PAIR("Paire"), 
	TREE_OF_A_KIND("Triple"), 
	FOUR_OF_A_KIND("Carre");
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
