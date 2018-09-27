package poker.game;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HandTest {

    Hand hand;

    @Before
    public void setUp() {
        hand = new Hand(1);
    }

    @Test
    public void goodNumberOfCardsInHandTest() {
        // 5 cards !
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        } catch (Exception e) {
            fail("This test should have passed");
        }
    }

    @Test
    public void notEnoughCardsInHandTest() {
        // 4 cards .... nop
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7", "12", "5", "6")));
            fail("This test should have failed");
        } catch (Exception e) {
        }
    }

    @Test
    public void tooMuchCardsInHandTest() {
        // 6 cards ... it's too much for our game
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7", "12", "5", "6", "6", "10")));
            fail("This test should have failed");
        } catch (Exception e) {
        }
    }

    @Test
    public void noCardsInHandTest() {
        // well ... don't play it's the same
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList()));
            fail("This test should have failed");
        } catch (Exception e) {
        }
    }
}
