package poker;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.Collections;

class Referee {

	/**
	 * Determines which hand wins
	 * 
	 * @param hand1
	 * @param hand2
	 * @return an int corresponding to the winner's handnumber
	 */
	int winner(Hand hand1, Hand hand2) {
		int value1 = hand1.handCardHightestValue();
		int value2 = hand2.handCardHightestValue();


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
