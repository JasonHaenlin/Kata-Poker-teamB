package poker;

public enum CombinationType {
	// @formatter:off
	HIGHCARD("Carte la plus haute"), 
	PAIR("Paire"), 
	TWO_PAIR("Paire"), 
	THREE_OF_A_KIND("Triple"), 
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

	public static CombinationType upperType(CombinationType type) {
		switch (type) {
		case HIGHCARD:
			return CombinationType.PAIR;
		case PAIR:
			return CombinationType.THREE_OF_A_KIND;
		case THREE_OF_A_KIND:
			return CombinationType.FOUR_OF_A_KIND;
		default:
			return CombinationType.HIGHCARD;
		}
	}
}
