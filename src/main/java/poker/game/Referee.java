package poker.game;

import java.util.List;

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
		List<Card> cardsInHand1 = hand1.getHand();
		List<Card> cardsInHand2 = hand2.getHand();

		if (c1.ordinal() < c2.ordinal()) {
			winnerMsg = "La main 2 gagne avec : " + c2.toString();
			return 2;
		} else if (c2.ordinal() < c1.ordinal()) {
			winnerMsg = "La main 1 gagne avec : " + c1.toString();
			return 1;
		} else {
			winnerMsg = "Les deux mains sont du meme type";

			switch (c1) {
				case HIGHESTCARD:
					for (int i = cardsInHand1.size() - 1; i >= 0; i--) {
						if (cardsInHand1.get(i).getIntValue() < cardsInHand2.get(i).getIntValue()) {
							winnerMsg = "La main 2 gagne avec : " + c2.toString() + cardsInHand2.get(i).getIntValue();
							return 2;
						} else if (cardsInHand1.get(i).getIntValue() > cardsInHand2.get(i).getIntValue()) {
							winnerMsg = "La main 1 gagne avec : " + c1.toString() + cardsInHand1.get(i).getIntValue();
							return 1;
						} else {
							winnerMsg = "Egalité des mains";
							return 0;
						}
					}
				case PAIR:
					if (hand1.getPatternValue().getValue() != hand2.getPatternValue().getValue()) {
						if (hand1.getPatternValue().getValue() < hand2.getPatternValue().getValue()) {
							winnerMsg = "La main 2 gagne avec : " + c2.toString() + hand2.getPatternValue().getValue();
							return 2;
						} else {
							winnerMsg = "La main 1 gagne avec : " + c1.toString() + hand1.getPatternValue().getValue();
							return 1;
						}

					} else {
						for (int i = cardsInHand1.size() - 1; i >= 0; i--) {
							if (cardsInHand1.get(i).getIntValue() < cardsInHand2.get(i).getIntValue()) { //TODO ajouter carte la plus haute dans l'affichage
								winnerMsg = "La main 2 gagne avec : " + c2.toString() + hand2.getPatternValue().getValue();
								return 2;
							} else if (cardsInHand1.get(i).getIntValue() > cardsInHand2.get(i).getIntValue()) { //TODO ajouter carte la plus haute dans l'affichage
								winnerMsg = "La main 1 gagne avec : " + c1.toString() + hand1.getPatternValue().getValue();
								return 1;
							} else {
								winnerMsg = "Egalité des mains";
								return 0;
							}
						}
					}
				default: // for Three of a kind, straight, full and four of a kind
					if (hand1.getPatternValue().getValue() < hand2.getPatternValue().getValue()) {
						winnerMsg = "La main 2 gagne avec : " + c2.toString() + hand2.getPatternValue().getValue();
						return 2;
					} else if (hand1.getPatternValue().getValue() > hand2.getPatternValue().getValue()) {
						winnerMsg = "La main 1 gagne avec : " + c1.toString() + hand1.getPatternValue().getValue();
						return 1;
					} else {
						winnerMsg = "Egalité des mains";
						return 0;
					}
			}
		}
	}

	public void checkForDuplicateCards(Hand hand1, Hand hand2) {
		for (Card card1 : hand1.getHand()) {
			if (hand2.getHand().contains(card1))
				throw new RuntimeException("Les doublons ne sont pas autorise entre deux mains " + card1.toString());
		}
	}

}
