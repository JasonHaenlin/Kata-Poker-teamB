package poker;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class HandTest {

    @Test
    public void handTest() {
        Hand hand = new Hand(1);
        assertTrue("1", hand.buildNewHand(new ArrayList<>(Arrays.asList("7","4","12","5","6"))));

        Hand hand2 = new Hand(1);
        assertFalse("2", hand2.buildNewHand(new ArrayList<>(Arrays.asList("7","12","5","6"))));

        Hand hand3 = new Hand(1);
        assertFalse("3", hand3.buildNewHand(new ArrayList<>(Arrays.asList("7","12","5","6","6","10"))));

        Hand hand4 = new Hand(1);
        assertFalse("3", hand4.buildNewHand(new ArrayList<>(Arrays.asList())));

    }



}