package poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class basicHandType {

    Hand hand1, hand2, hand3, hand4, hand5;
    BasicHandType basicHandType;

    @Before
    public void setUp() {
        basicHandType = new BasicHandType();

        hand1 = new Hand(1);
        hand2 = new Hand(1);
        hand3 = new Hand(1);
        hand4 = new Hand(1);
        hand5 = new Hand(1);
    }

    @Test
    public void testAllInOne() {
        // pair in hand
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("5", "6", "7", "7", "12")));
        assertTrue("PAIR :", basicHandType.scoring(hand1));
        assertEquals(CombinationType.PAIR, basicHandType.getCombinationType());
        /// no pair in hand
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("3", "5", "10", "12", "14")));
        assertFalse("HIGHCARD :", basicHandType.scoring(hand2));
        assertEquals(CombinationType.HIGHCARD, basicHandType.getCombinationType());
        // threeOfAKind so not a pair
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("4", "7", "7", "7", "12")));
        assertTrue("THREE_OF_A_KIND :", basicHandType.scoring(hand3));
        assertEquals(CombinationType.THREE_OF_A_KIND, basicHandType.getCombinationType());
        // FourOfAKind so not a pair
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("8", "8", "8", "8", "10")));
        assertTrue("FOUR_OF_A_KIND :", basicHandType.scoring(hand4));
        assertEquals(CombinationType.FOUR_OF_A_KIND, basicHandType.getCombinationType());
        // Two pair so not a pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "9", "9", "10")));
        assertTrue("TWO_PAIR :", basicHandType.scoring(hand5));
        assertEquals(CombinationType.TWO_PAIR, basicHandType.getCombinationType());
    }

}
