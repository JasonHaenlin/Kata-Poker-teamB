package poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HandTypeTest {

    Hand hand1, hand2, hand3, hand4, hand5;
    HandType basicHandType;

    @Before
    public void setUp() {
        basicHandType = new HandType();

        hand1 = new Hand(1);
        hand2 = new Hand(1);
        hand3 = new Hand(1);
        hand4 = new Hand(1);
        hand5 = new Hand(1);
    }

    @Test
    public void findAPairTest() {

        hand1.buildNewHand(new ArrayList<>(Arrays.asList("5", "6", "7", "7", "12")));
        assertTrue("PAIR 1:", basicHandType.scoring(hand1));
        assertEquals(CombinationType.PAIR, basicHandType.getCombinationType());

        hand2.buildNewHand(new ArrayList<>(Arrays.asList("5", "7", "7", "7", "12")));
        assertTrue("PAIR 2:", basicHandType.scoring(hand2));
        assertNotEquals(CombinationType.PAIR, basicHandType.getCombinationType());

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("5", "6", "7", "12", "12")));
        assertTrue("PAIR 3:", basicHandType.scoring(hand3));
        assertEquals(CombinationType.PAIR, basicHandType.getCombinationType());

        hand4.buildNewHand(new ArrayList<>(Arrays.asList("5", "5", "9", "7", "12")));
        assertTrue("PAIR 4:", basicHandType.scoring(hand4));
        assertEquals(CombinationType.PAIR, basicHandType.getCombinationType());

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("5", "6", "8", "8", "12")));
        assertTrue("PAIR 5:", basicHandType.scoring(hand5));
        assertEquals(CombinationType.PAIR, basicHandType.getCombinationType());
    }

    @Test
    public void findAThreeOfAKindTest() {

        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4", "7", "7", "7", "12")));
        assertTrue("THREE_OF_A_KIND 1:", basicHandType.scoring(hand1));
        assertEquals(CombinationType.THREE_OF_A_KIND, basicHandType.getCombinationType());

        hand2.buildNewHand(new ArrayList<>(Arrays.asList("4", "7", "9", "7", "12")));
        assertTrue("THREE_OF_A_KIND 2:", basicHandType.scoring(hand2));
        assertNotEquals(CombinationType.THREE_OF_A_KIND, basicHandType.getCombinationType());

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("4", "7", "9", "9", "9")));
        assertTrue("THREE_OF_A_KIND 3:", basicHandType.scoring(hand3));
        assertEquals(CombinationType.THREE_OF_A_KIND, basicHandType.getCombinationType());

        hand4.buildNewHand(new ArrayList<>(Arrays.asList("4", "4", "4", "7", "12")));
        assertTrue("THREE_OF_A_KIND 4:", basicHandType.scoring(hand4));
        assertEquals(CombinationType.THREE_OF_A_KIND, basicHandType.getCombinationType());

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("4", "7", "4", "7", "12")));
        assertTrue("THREE_OF_A_KIND 5:", basicHandType.scoring(hand5));
        assertNotEquals(CombinationType.THREE_OF_A_KIND, basicHandType.getCombinationType());
    }

    @Test
    public void findAFourOfAKindTest() {

        hand1.buildNewHand(new ArrayList<>(Arrays.asList("8", "8", "8", "8", "10")));
        assertTrue("FOUR_OF_A_KIND 1:", basicHandType.scoring(hand1));
        assertEquals(CombinationType.FOUR_OF_A_KIND, basicHandType.getCombinationType());

        hand2.buildNewHand(new ArrayList<>(Arrays.asList("8", "8", "8", "13", "10")));
        assertTrue("FOUR_OF_A_KIND 2:", basicHandType.scoring(hand2));
        assertNotEquals(CombinationType.FOUR_OF_A_KIND, basicHandType.getCombinationType());

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("10", "11", "11", "11", "11")));
        assertTrue("FOUR_OF_A_KIND 3:", basicHandType.scoring(hand3));
        assertEquals(CombinationType.FOUR_OF_A_KIND, basicHandType.getCombinationType());

        hand4.buildNewHand(new ArrayList<>(Arrays.asList("4", "4", "4", "4", "14")));
        assertTrue("FOUR_OF_A_KIND 4:", basicHandType.scoring(hand4));
        assertEquals(CombinationType.FOUR_OF_A_KIND, basicHandType.getCombinationType());

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("9", "8", "8", "8", "10")));
        assertTrue("FOUR_OF_A_KIND 5:", basicHandType.scoring(hand5));
        assertNotEquals(CombinationType.FOUR_OF_A_KIND, basicHandType.getCombinationType());
    }

    @Test
    public void findATwoPairTest() {

        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "9", "9", "10")));
        assertTrue("TWO_PAIR 1:", basicHandType.scoring(hand1));
        assertEquals(CombinationType.TWO_PAIR, basicHandType.getCombinationType());

        hand2.buildNewHand(new ArrayList<>(Arrays.asList("10", "10", "11", "11", "14")));
        assertTrue("TWO_PAIR 2:", basicHandType.scoring(hand2));
        assertEquals(CombinationType.TWO_PAIR, basicHandType.getCombinationType());

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "9", "13", "13")));
        assertTrue("TWO_PAIR 3:", basicHandType.scoring(hand3));
        assertEquals(CombinationType.TWO_PAIR, basicHandType.getCombinationType());

        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "9", "4", "10")));
        assertTrue("TWO_PAIR 4:", basicHandType.scoring(hand4));
        assertNotEquals(CombinationType.TWO_PAIR, basicHandType.getCombinationType());

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "7", "7", "10")));
        assertTrue("TWO_PAIR 5:", basicHandType.scoring(hand5));
        assertNotEquals(CombinationType.TWO_PAIR, basicHandType.getCombinationType());
    }

    @Test
    public void HighCardTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("3", "5", "10", "12", "14")));
        assertFalse("HIGHCARD 1:", basicHandType.scoring(hand1));
        assertEquals(CombinationType.HIGHCARD, basicHandType.getCombinationType());
    }

}
