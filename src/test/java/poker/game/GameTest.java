package poker.game;

import static org.junit.Assert.fail;

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
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5")));
            fail("first test should have failed");
        } catch (Exception e) {
        }
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("14", "15", "3", "16", "5")));
            fail("second test should have failed");

        } catch (Exception e) {
        }
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "5", "6", "7", "15")));
            fail("third test should have failed");

        } catch (Exception e) {
        }
    }

    @Test
    public void buildingDeckValidTest() {
        // cards in the right value of range
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "2", "3", "4", "5")));
        } catch (Exception e) {
            fail("first test should have passed");
        }
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("2", "5", "14", "12", "10")));
        } catch (Exception e) {
            fail("second test should have passed");
        }
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("9", "9", "7", "9", "10")));
        } catch (Exception e) {
            fail("third test should have passed");
        }
    }

}
