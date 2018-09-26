package poker;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

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
        assertTrue(hand.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6"))));
    }

    @Test
    public void notEnoughCardsInHandTest() {
        // 4 cards .... nop
        assertFalse(hand.buildNewHand(new ArrayList<>(Arrays.asList("7", "12", "5", "6"))));
    }

    @Test
    public void tooMuchCardsInHandTest() {
        // 6 cards ... it's too much for our game
        assertFalse(hand.buildNewHand(new ArrayList<>(Arrays.asList("7", "12", "5", "6", "6", "10"))));
    }

    @Test
    public void noCardsInHandTest() {
        // well ... don't play it's the same
        assertFalse(hand.buildNewHand(new ArrayList<>(Arrays.asList())));
    }
}
