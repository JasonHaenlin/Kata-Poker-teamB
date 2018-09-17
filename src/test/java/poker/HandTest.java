package poker;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void handTest() {
        Hand hand = new Hand(1);
        hand.buildNewHand(7);
        assertEquals(7, hand.handCardValue());
    }

}