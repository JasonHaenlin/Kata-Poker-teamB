package poker;

public enum CombinationType {
	HIGHCARD("Carte la plus haute"),
	PAIR("Carte la plus haute"),
	TRIPLE("Carte la plus haute"),
	FOUROFAKIND("Carte la plus haute");

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