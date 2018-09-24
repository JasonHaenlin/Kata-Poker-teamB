package poker;



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
	int winner(Hand hand1, Hand hand2) { //Permet de detecter le gagnant à la carte haute
		ArrayList<Integer> val1 = new ArrayList();	//Créer des listes qui vont contenir les valeurs
		ArrayList<Integer> val2 = new ArrayList();	//des cartes des deux mains

		for(int i = 0;i<5;i++)
		{
			val1.add(hand1.getHand().get(i).getValue());
			val2.add(hand2.getHand().get(i).getValue());
		}

		int value1 = Collections.max(val1);	//Detecte le max des deux liste val1 et val2
		int value2 = Collections.max(val2);

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
