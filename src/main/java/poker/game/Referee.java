package poker.game;

import poker.game.exception.CardDuplicationBetweenPlayerRuntimeException;

/**
 * 
 * Referee class, decides of the winner
 * 
 * @author Ruben Houri
 * @author Maxime Castellano
 * @author Vincent Ung
 * @author Jason Haenlin
 */

class Referee {

	private String winnerMsg;
	private Hand hand1;
	private Hand hand2;
	private Hand winnerHand;

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
		checkForDuplicateCards(hand1, hand2);
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
		hand1.computeHandPattern();
		hand2.computeHandPattern();
		if (isThereAWinner()) {
			return setTheResult(true);
		}
		if (isPotentialWinnerExist()) {
			return resultOfTheReferee();
		}
		return setTheResult(false);
	}

	private boolean isPotentialWinnerExist() {
		if (hand1.getType() == CombinationType.HIGHESTCARD)
			return !(hand1.isEmpty() || hand2.isEmpty());
		hand1.removeAdvancedPatterns();
		hand2.removeAdvancedPatterns();
		return true;

	}

	private int setTheResult(boolean verdict) {
		if (verdict) {
			int player = winnerHand.getHandNumber();
			CombinationType comb = winnerHand.getType();
			String combType = winnerHand.getPatternValue().toString();
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
	private void setWinnerMsg(int winner, CombinationType winningCombination, String winningPatternValue) {
		winnerMsg = "La main " + (winner + 1) + " gagne avec " + winningCombination.toString() + winningPatternValue;
	}

	private void setWinnerMsg() {
		winnerMsg = "Egalite";
	}

	public void checkForDuplicateCards(Hand hand1, Hand hand2) {
		for (Card card1 : hand1.getHand()) {
			if (hand2.getHand().contains(card1))
				throw new CardDuplicationBetweenPlayerRuntimeException(card1.toString());
		}
	}

}
