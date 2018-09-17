package poker;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void buildingDeckTest() {
        Hand hand = new Hand(1);
        assertFalse("1", hand.buildNewHand(1));
        assertFalse("2", hand.buildNewHand(15));
        assertFalse("3", hand.buildNewHand(0));
        assertTrue("4", hand.buildNewHand(5));
        assertTrue("5", hand.buildNewHand(7));
        assertTrue("6", hand.buildNewHand(14));
    }

}