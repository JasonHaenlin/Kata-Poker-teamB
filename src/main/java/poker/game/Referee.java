package poker.game;

import poker.game.exception.CardDuplicationBetweenPlayerRuntimeException;

/**
 * This class judge who is the winner
 */
class Referee {

	private String winnerMsg;
	private Hand hand1, hand2, winnerHand;

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

	private int computeScoreAd(Hand hand) {
		int pattern = hand.getType().getStrength();
		int value = hand.getPatternValue().getValue();
		int extra = 0;
		if (hand.getPatternValueExtra() != null)
			extra = hand.getPatternValueExtra().getValue();
		return (pattern * value) + (pattern / 10 * extra);

	}

	private int resultOfTheReferee() {
		hand1.getHandPattern();
		hand2.getHandPattern();
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
			int player = winnerHand.getHandNumber();
			CombinationType comb = winnerHand.getType();
			int combType = winnerHand.getPatternValue().getValue();
			setWinnerMsg(player, comb, combType);
			return player;
		}
		setWinnerMsg();
		return 0;
	}

	private boolean isThereAWinner() {
		int h1 = computeScoreAd(hand1);
		int h2 = computeScoreAd(hand2);
		if (h1 == h2)
			return false;
		if (h1 > h2)
			winnerHand = hand1;
		else
			winnerHand = hand2;
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
		winnerMsg = "La main " + (winner+1) + " gagne avec : " + winningCombination.toString() + winningPatternValue;
	}

	private void setWinnerMsg() {
		winnerMsg = "Egalité des mains";
	}

	public void checkForDuplicateCards() {
		for (Card card1 : hand1.getHand()) {
			if (hand2.getHand().contains(card1))
				throw new CardDuplicationBetweenPlayerRuntimeException(card1.toString());
		}
	}

}
