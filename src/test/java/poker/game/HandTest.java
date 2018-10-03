package poker.game;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HandTest {


    Hand hand,hand1, hand2, hand3, hand4, hand5, hand6, hand7;

    @Before
    public void setUp() {

        hand = new Hand(1);

        hand1 = new Hand(1);
        hand2 = new Hand(1);
        hand3 = new Hand(1);
        hand4 = new Hand(1);
        hand5 = new Hand(1);
        hand6 = new Hand(1);
        hand7 = new Hand(1);

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

    @Test
    public void testPair() {
        // pair in hand
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(7, hand1.isPairDetected(hand1.getHand()));
        /// no pair in hand
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, hand2.isPairDetected(hand2.getHand()));
        // other pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "9", "12", "8", "8")));
        assertEquals(8, hand5.isPairDetected(hand5.getHand()));
    }

    @Test
    public void testThreeOfAKind() {
        // not a ThreeOfAkind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, hand1.isTreeOfAKindDetected(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, hand2.isTreeOfAKindDetected(hand2.getHand()));
        // a ThreeOfAKind is present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(7, hand3.isTreeOfAKindDetected(hand3.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, hand5.isTreeOfAKindDetected(hand5.getHand()));
    }

    @Test
    public void testFourOfAKind() {
        // not a FourOfAKind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, hand1.isFourOfAKindDetected(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, hand2.isFourOfAKindDetected(hand2.getHand()));
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(-1, hand3.isFourOfAKindDetected(hand3.getHand()));
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(7, hand4.isFourOfAKindDetected(hand4.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, hand5.isFourOfAKindDetected(hand5.getHand()));
    }

    @Test
    public void testFull() {
        //Test avec une pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "10", "11", "12")));
        assertArrayEquals(new int[]{-1, -1}, hand1.isFullDetected(hand1.getHand()));
        //Test avec brelan
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "7", "5", "6")));
        assertArrayEquals(new int[]{-1, -1}, hand2.isFullDetected(hand2.getHand()));
        //Test full 7 par les 8
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "7", "8", "8")));
        assertArrayEquals(new int[]{7, 8}, hand3.isFullDetected(hand3.getHand()));
        //Test full 8 par les 7
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "8", "8", "8")));
        assertArrayEquals(new int[]{8, 7}, hand4.isFullDetected(hand4.getHand()));
        //Test avec carree
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "7", "7", "8")));
        assertArrayEquals(new int[]{-1, -1}, hand5.isFullDetected(hand5.getHand()));
        //Test avec pair
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "9", "11", "10")));
        assertArrayEquals(new int[]{-1, -1}, hand6.isFullDetected(hand6.getHand()));
        // Test double pair
        hand7.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "9", "9", "10")));
        assertArrayEquals(new int[]{-1, -1}, hand7.isFullDetected(hand7.getHand()));
    }

    @Test
    public void testStraight() {
        // Not a straight
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("3", "7", "12", "5", "6")));
        assertEquals(-1, hand1.isStraight(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("12", "14", "13", "2", "3")));
        assertEquals(-1, hand2.isStraight(hand2.getHand()));
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("14", "4", "2", "5", "3")));
        assertEquals(5, hand3.isStraight(hand3.getHand()));
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("11", "13", "14", "12", "10")));
        assertEquals(14, hand4.isStraight(hand4.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("3", "5", "6", "4", "2")));
        assertEquals(6, hand5.isStraight(hand5.getHand()));

    }


}
