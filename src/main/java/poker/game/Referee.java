package poker.game;

/**
 * This class judge who is the winner
 */
class Referee {

	private String winnerMsg;

	Referee() {
		this.winnerMsg = "";
	}

	/**
	 * print the result of the game after the check has been done.
	 */
	void printResultOfTheGame() {
		System.out.println(winnerMsg);
	}

	/**
	 * compare the hand combinations and store the result has a string. Use
	 * <strong>printResultOfTheGame()</strong> to display the result.
	 * 
	 * @return
	 * @param hand1
	 * @param hand2
	 */
	int establishTheWinner(Hand hand1, Hand hand2) {
		checkForDuplicateCards(hand1, hand2);
		CombinationType c1, c2;
		c1 = hand1.getHandPattern();
		c2 = hand2.getHandPattern();

		if (c1.ordinal() < c2.ordinal()) {
			winnerMsg = "La main 2 gagne avec : " + c2.toString();
			return 2;
		} else if (c2.ordinal() < c1.ordinal()) {
			winnerMsg = "La main 1 gagne " + c1.toString();
			return 1;
		} else {
			winnerMsg = "Les deux mains sont du même type";
			return 0;
		}
	}

	public void checkForDuplicateCards(Hand hand1, Hand hand2) {
		for (Card card1 : hand1.getHand()) {
			if (hand2.getHand().contains(card1))
				throw new RuntimeException("Les doublons ne sont pas autorise entre deux mains " + card1.toString());
		}
	}

}
