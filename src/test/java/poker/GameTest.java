package poker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class GameTest {

    @Test
    public void buildingDeckTest() {
        Hand hand = new Hand(1);
        assertFalse("1", hand.buildNewHand(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5")))); // Erreur de
                                                                                                      // saisie
        assertFalse("2", hand.buildNewHand(new ArrayList<>(Arrays.asList("14", "15", "3", "16", "5")))); // Erreur de
                                                                                                         // saisie
        assertFalse("3", hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "5", "6", "7", "15")))); // Erreur de
                                                                                                       // saisie
        assertTrue("4", hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "2", "3", "4", "5"))));
        assertTrue("5", hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "5", "14", "12", "10"))));
        assertTrue("6", hand.buildNewHand(new ArrayList<>(Arrays.asList("9", "9", "7", "9", "10"))));
    }

}