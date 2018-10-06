package poker.game;

/**
 * This class judge who is the winner
 */
class Referee {

	private String winnerMsg;
	private CombinationType c1, c2;
	private Hand hand1, hand2;

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
		this.hand1 = hand1;
		this.hand2 = hand2;
		checkForDuplicateCards();
		return resultOfTheReferee();
	}

	private int resultOfTheReferee() {
		c1 = hand1.getHandPattern();
		c2 = hand2.getHandPattern();
		if (isThereAWinner()) {
			return setTheResult(true);
		}
		if (isPotentialWinnerExist()) {
			return resultOfTheReferee();
		}
		return setTheResult(false);
	}

	private boolean isPotentialWinnerExist() {
		switch (hand1.getType()) {
		case HIGHESTCARD:
			if (hand1.isEmpty() || hand2.isEmpty())
				return false;
			return true;
		case ROYAL_QUINTE_FLUSH:
			return false;
		default:
			hand1.removeAdvancedPatterns();
			hand2.removeAdvancedPatterns();
			return true;
		}
	}

	private int setTheResult(boolean verdict) {
		if (verdict) {
			if (c1.getStrength() == c2.getStrength()) {
				if (computeScore(hand1) > computeScore(hand2)) {
					setWinnerMsg(1, c1, hand1.getPatternValue().getValue());
					return 1;
				} else {
					setWinnerMsg(2, c2, hand2.getPatternValue().getValue());
					return 2;
				}
			} else if (c1.getStrength() > c2.getStrength()) {
				setWinnerMsg(1, c1, hand1.getPatternValue().getValue());
				return 1;
			} else {
				setWinnerMsg(2, c2, hand2.getPatternValue().getValue());
				return 2;
			}
		}
		setWinnerMsg();
		return 0;
	}

	private int computeScore(Hand hand) {
		return hand.getPatternValue().getValue() * 10 + hand.getPatternValueExtra().getValue();
	}

	private boolean isThereAWinner() {
		if (c1.getStrength() != c2.getStrength()) {
			return true;
		}
		if (this.hand1.getPatternValue() == this.hand2.getPatternValue()) {
			if (this.hand1.getPatternValueExtra() == this.hand2.getPatternValueExtra()) {
				return false;
			}
			return true;
		}
		return true;
	}

	/**
	 * sets the winner message that will be displayed
	 *
	 * @param winner
	 * @param winningCombination
	 * @param winningPatternValue
	 */
	private void setWinnerMsg(int winner, CombinationType winningCombination, int winningPatternValue) {
		winnerMsg = "La main " + winner + " gagne avec : " + winningCombination.toString() + winningPatternValue;
	}

	private void setWinnerMsg() {
		winnerMsg = "Egalité des mains";
	}

	public void checkForDuplicateCards() {
		for (Card card1 : hand1.getHand()) {
			if (hand2.getHand().contains(card1))
				throw new RuntimeException("Les doublons ne sont pas autorise entre deux mains " + card1.toString());
		}
	}

}
