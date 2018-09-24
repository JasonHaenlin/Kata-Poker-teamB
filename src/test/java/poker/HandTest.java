package poker;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class HandTest {

    @Test
    public void handTest() {
        Hand hand = new Hand(1);
        hand.buildNewHand(new ArrayList<>(Arrays.asList("7")));
        assertEquals(7, hand.handCardHightestValue());

        Hand hand2 = new Hand(1);
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("14")));
        assertEquals(14, hand2.handCardHightestValue());

    }

}