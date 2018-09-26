package poker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    Hand hand;

    @Before
    public void setUp() {
        hand = new Hand(1);
    }

    @Test
    public void buildingDeckErrorTest() {
        // cards not in the right range (2 to 14 included)
        assertFalse("1",
                hand.buildNewHand(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"))));
        assertFalse("2",
                hand.buildNewHand(new ArrayList<>(Arrays.asList("14", "15", "3", "16", "5"))));
        assertFalse("3",
                hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "5", "6", "7", "15"))));
    }

    @Test
    public void buildingDeckValidTest() {
        // cards in the right value of range
        assertTrue("4", hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "2", "3", "4", "5"))));
        assertTrue("5",
                hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "5", "14", "12", "10"))));
        assertTrue("6",
                hand.buildNewHand(new ArrayList<>(Arrays.asList("9", "9", "7", "9", "10"))));
    }

}
