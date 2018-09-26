package poker;

class Referee {

	/**
	 * Determines which hand wins
	 * 
	 * @param hand1
	 * @param hand2
	 * @return an int corresponding to the winner's handnumber
	 */

	 CombinationType typeHand(Hand hand)  //Detecte le type de la main entre Carree, Brelan, Pair et carte haute
    {
        if(findSquare(hand) != -1)
        {
            return CombinationType.FOUROFAKIND;
        }
        else if(findTriple(hand) != -1)
        {
            return CombinationType.TRIPLE;
        }
        else if(findPair(hand) != -1)
        {
            return CombinationType.PAIR;
        }
        else {return CombinationType.HIGHCARD;}
    }

	int winner(Hand hand1, Hand hand2) {

	    CombinationType c1 = typeHand(hand1); //Récupère l'ordinal du type de la main 1
        CombinationType c2 = typeHand(hand2); //Récupère l'ordinal du type de la main 2

        if (c1.ordinal() < c2.ordinal()){
            System.out.println("La main 2 gagne avec : "+ c2.toString());
            return 2;
        }
        else if(c2.ordinal() < c1.ordinal()){
            System.out.println("La main 1 gagne "+ c1.toString());
            return 1;
        }
        else
        {
            System.out.println("Les deux mains sont du même type");
            return 0;
        }
	}
}
