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
            hand.buildNewHand(new ArrayList<>(Arrays.asList("1Tr", "2Pi", "3Ca", "7Ca", "5Ca")));
            fail("first test should have failed");
        } catch (Exception e) {
        }
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "15Tr", "3Ca", "16Ca", "5Ca")));
            fail("second test should have failed");

        } catch (Exception e) {
        }
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("2Pi", "5Ca", "6Co", "7Tr", "15Tr")));
            fail("third test should have failed");

        } catch (Exception e) {
        }
    }

    @Test
    public void buildingDeckValidTest() {
        // cards in the right value of range
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("2Ca", "2Pi", "3Ca", "7Ca", "5Ca")));
        } catch (Exception e) {
            fail("first test should have passed");
        }
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("2Pi", "5Ca", "ATr", "DCo", "10Pi")));
        } catch (Exception e) {
            fail("second test should have passed");
        }
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("9Tr", "9Ca", "7Tr", "9Co", "10Pi")));
        } catch (Exception e) {
            fail("third test should have passed");
        }
    }

}
