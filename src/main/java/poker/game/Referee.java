package poker.game;

import java.util.List;

class Referee {

	String winnerMsg;
	Detection detection;

	/**
	 * 
	 */
	Referee() {
		this.winnerMsg = "";
		detection = new Detection();
	}

	/**
	 * 
	 */
	void printResultOfTheGame() {
		System.out.println(winnerMsg);
	}

	/**
	 * 
	 * @return
	 */
	int establishTheWinner() {
		CombinationType c1, c2;
		c1 = detection.getType1();
		c2 = detection.getType2();
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

	/**
	 *
	 * @param hand1
	 * @param hand2
	 */
	void checkHandsCombination(Hand hand1, Hand hand2) {
		detection.detectionHand(hand1, hand2);
	}

}
