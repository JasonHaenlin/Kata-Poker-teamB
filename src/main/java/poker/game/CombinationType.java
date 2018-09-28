package poker.game;

enum CombinationType {
	// @formatter:off
	HIGHESTCARD("Carte la plus haute"),
	PAIR("Paire"), 
	TRIPLE("Triple"), 
	FOUROFAKIND("Carre");
	// @formatter:on

	private String typeOfHand = "";

	CombinationType(String typeOfHand) {
		this.typeOfHand = typeOfHand;
	}

	@Override
	public String toString() {
		return this.typeOfHand;
	}

	String getTypeOfHand() {
		return typeOfHand;
	}
}
