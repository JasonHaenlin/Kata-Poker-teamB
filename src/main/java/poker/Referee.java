package poker;

class Referee {

	/**
	 * Determines which hand wins
	 * 
	 * @param card1
	 * @param card2
	 * @return an int corresponding to the winner's handnumber
	 */
	int winner(Card card1, Card card2) {
		int value1 = card1.getValue();
		int value2 = card2.getValue();
		if (value1 < value2) {
			System.out.println("La main 2 gagne avec la carte la plus élevée : " + value2);
			return 2;
		} else if (value1 > value2) {
			System.out.println("La main 1 gagne avec la carte la plus élevée : " + value1);
			return 1;
		} else {
			System.out.println(" Egalité !");
			return 0;
		}

	}

}
