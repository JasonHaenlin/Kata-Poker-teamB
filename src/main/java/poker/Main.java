package poker;

public class Main {

    public static void main(String[] args) {

        java.util.Scanner entree = new java.util.Scanner(System.in);
        // Compare 2 valeurs et vérifie qu'elles sont bien dans l'intervalle donné
        System.out.println("Entrez la main N°1");
        int main1 = entree.nextInt();
        System.out.println("Entrez la main N°2");
        int main2 = entree.nextInt();

        if (2<= main1 && main1 <= 14 && 2<= main2 && main2 <= 14 ) {
            if (main1 < main2) {
                System.out.println("La main N°2 est meilleur");
            } else if (main1 > main2){
                System.out.println("La main N°1 est meilleur");
            }
            else {
                System.out.println(" Egalité !");
            }
        } else {
            System.out.println("Une des mains est impossible !");
        }
        /**
         * Main program
         */
        HandCard hand = new HandCard();
        System.out.println(hand.HandCardValue());
    }
}
