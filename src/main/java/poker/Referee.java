package poker;

class Referee {

	/**
	 * Determines which hand wins
	 * 
	 * @param hand1
	 * @param hand2
	 * @return an int corresponding to the winner's handnumber
	 */

	String typeHand(Hand hand)  //Detecte le type de la main entre Carree, Brelan, Pair et carte haute
    {
        if(findSquare(hand) != -1)
        {
            return "Carre";
        }
        else if(findTriple(hand) != -1)
        {
            return "Brelan";
        }
        else if(findPair(hand) != -1)
        {
            return "Paire";
        }
        else {return "Carte la plus haute";}
    }

	int winner(Hand hand1, Hand hand2) {

	    CombinationType combinaison1 = new CombinationType(typeHand(hand1));
        CombinationType combinaison2 = new CombinationType(typeHand(hand2));

	    int h1 = CombinationType.getType(hand1).ordinal(); //Récupère l'ordinal du type de la main 1
        int h2 = CombinationType.getType(hand2).ordinal(); //Récupère l'ordinal du type de la main 2

        if (h1 < h2){
            System.out.println("La main 2 gagne ");
            return 2;
        }
        else if(h2 < h1){
            System.out.println("La main 1 gagne ");
            return 1;
        }
        else
        {
            System.out.println("Les deux mains sont du même type");
            return 0;
        }
	}
}
