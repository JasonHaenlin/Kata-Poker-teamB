package poker;

public enum CombinationType {
	// @formatter:off
	HIGHCARD("Carte la plus haute"), 
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

	public String getTypeOfHand() {
		return typeOfHand;
	}
}
