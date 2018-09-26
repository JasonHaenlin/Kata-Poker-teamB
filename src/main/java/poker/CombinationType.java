package poker;

public enum CombinationType {
	HIGHCARD("Carte la plus haute"),
	PAIR("Paire"),
	TRIPLE("Triple"),
	FOUROFAKIND("Carre");

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