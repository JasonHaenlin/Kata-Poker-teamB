package poker;

import java.util.List;

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
			System.out.println("Egalité !");
			return 0;
		}
	}

	/**
	 *
	 * @param hand
	 * @return La valeur de la carte qui forme la pair si il y a une pair dans hand sinon elle retourne -1.
	 * En cas de double pair, retourne uniquement la pair la plus faible.
	 */
	int findPair(Hand hand){
		List<Card> handlist = hand.getHand();
		for (int i=0;i<handlist.size()-3;i++){
			Card first = handlist.get(i);
			Card second = handlist.get(i+1);
			Card third = handlist.get(i+2);
			Card four = handlist.get(i+3);
			if(first.equals(second) && !second.equals(third)){
				return first.getValue();
			}
			if(!first.equals(second) && second.equals(third) && !third.equals(four)){
				return second.getValue();
			}
			if( !second.equals(third) && third.equals(four)){
				return third.getValue();
			}

		}
		return -1;
	}

	/**
	 *
	 * @param hand
	 * @return La valeur de la carte qui forme le brelan si il y a un brelan dans hand sinon elle retourne -1.
	 */
	int findTriple(Hand hand){
		List<Card> handlist = hand.getHand();
		for (int i=0;i<handlist.size()-4;i++){
			Card first = handlist.get(i);
			Card second = handlist.get(i+1);
			Card third = handlist.get(i+2);
			Card four = handlist.get(i+3);
			Card five = handlist.get(i+4);
			if(first.equals(second) && second.equals(third) && !third.equals(four) ){
				return first.getValue();
			}
			if(!first.equals(second) && second.equals(third) && third.equals(four) && !four.equals(five)){
				return second.getValue();
			}
			if(!second.equals(third) && third.equals(four) && four.equals(five)){
				return third.getValue();
			}

		}
		return -1;
	}

	/**
	 *
	 * @param hand
	 * @return La valeur de la carte qui forme le carré  si il y a un carré dans hand sinon elle retourne -1.
	 */
	int findFourOfAKind(Hand hand){
		List<Card> handlist = hand.getHand();
		for (int i=0;i<handlist.size()-4;i++){
			Card first = handlist.get(i);
			Card second = handlist.get(i+1);
			Card third = handlist.get(i+2);
			Card four = handlist.get(i+3);
			Card five = handlist.get(i+4);
			if(first.equals(second) && second.equals(third) && third.equals(four) && !four.equals(five)){
				return first.getValue();
			}
			if(!first.equals(second) && second.equals(third) && third.equals(four) && four.equals(five)){
				return second.getValue();
			}

		}
		return -1;
	}
}

