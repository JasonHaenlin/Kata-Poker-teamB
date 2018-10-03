package poker.game;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HandTest {

    Hand hand, hand1, hand2, hand3, hand4, hand5, hand6, hand7;

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
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "DCa", "5Tr", "6Tr")));
        } catch (Exception e) {
            fail("This test should have passed");
        }
    }

    @Test
    public void notEnoughCardsInHandTest() {
        // 4 cards .... nop
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "DCa", "5Ca", "6Pi")));
            fail("This test should have failed");
        } catch (Exception e) {
        }
    }

    @Test
    public void tooMuchCardsInHandTest() {
        // 6 cards ... it's too much for our game
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "DCa", "5Co", "6Co", "7Co", "10Ca")));
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
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "DCa", "5Co", "6Pi")));
        assertEquals(7, hand1.isPairDetected(hand1.getHand()));
        /// no pair in hand
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "5Co", "6Pi")));
        assertEquals(-1, hand2.isPairDetected(hand2.getHand()));
        // other pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "9Ca", "DCa", "8Pi", "8Tr")));
        assertEquals(8, hand5.isPairDetected(hand5.getHand()));
    }

    @Test
    public void testThreeOfAKind() {
        // not a ThreeOfAkind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Pi", "DCa", "5Co", "6Pi")));
        assertEquals(-1, hand1.isTreeOfAKindDetected(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "5Co", "6Pi")));
        assertEquals(-1, hand2.isTreeOfAKindDetected(hand2.getHand()));
        // a ThreeOfAKind is present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "7Ca", "7Pi")));
        assertEquals(7, hand3.isTreeOfAKindDetected(hand3.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "DCa", "8Tr", "8Ca")));
        assertEquals(-1, hand5.isTreeOfAKindDetected(hand5.getHand()));
    }

    @Test
    public void testFourOfAKind() {
        // not a FourOfAKind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Ca", "7Tr", "DCa", "5Co", "6Pi")));
        assertEquals(-1, hand1.isFourOfAKindDetected(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "5Co", "6Pi")));
        assertEquals(-1, hand2.isFourOfAKindDetected(hand2.getHand()));
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "7Pi", "7Ca")));
        assertEquals(-1, hand3.isFourOfAKindDetected(hand3.getHand()));
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7Co", "7Ca", "DCa", "7Tr", "7Pi")));
        assertEquals(7, hand4.isFourOfAKindDetected(hand4.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Co", "DCa", "8Co", "8Tr")));
        assertEquals(-1, hand5.isFourOfAKindDetected(hand5.getHand()));
    }

    @Test
    public void testFull() {
        //Test avec une pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Co", "7Tr", "10Pi", "VTr", "DCa")));
        assertArrayEquals(new int[] { -1, -1 }, hand1.isFullDetected(hand1.getHand()));
        //Test avec brelan
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Co", "7Ca", "7Tr", "5Co", "6Pi")));
        assertArrayEquals(new int[] { -1, -1 }, hand2.isFullDetected(hand2.getHand()));
        //Test full 7 par les 8
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "7Pi", "8Ca", "8Tr")));
        assertArrayEquals(new int[] { 7, 8 }, hand3.isFullDetected(hand3.getHand()));
        //Test full 8 par les 7
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "8Ca", "8Pi", "8Tr")));
        assertArrayEquals(new int[] { 8, 7 }, hand4.isFullDetected(hand4.getHand()));
        //Test avec carree
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "7Co", "7Pi", "8Tr")));
        assertArrayEquals(new int[] { -1, -1 }, hand5.isFullDetected(hand5.getHand()));
        //Test avec pair
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Pi", "9Ca", "VTr", "10Pi")));
        assertArrayEquals(new int[] { -1, -1 }, hand6.isFullDetected(hand6.getHand()));
        // Test double pair
        hand7.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Pi", "9Ca", "9Pi", "10Pi")));
        assertArrayEquals(new int[] { -1, -1 }, hand7.isFullDetected(hand7.getHand()));
    }

    @Test
    public void testStraight() {
        // Not a straight
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("3Ca", "7Tr", "DCa", "5Co", "6Pi")));
        assertEquals(-1, hand1.isStraight(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("DCa", "ATr", "RCo", "2Tr", "3Ca")));
        assertEquals(-1, hand2.isStraight(hand2.getHand()));
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "4Pi", "2Tr", "5Co", "3Ca")));
        assertEquals(5, hand3.isStraight(hand3.getHand()));
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("VTr", "RCo", "ATr", "DCa", "10Pi")));
        assertEquals(14, hand4.isStraight(hand4.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("3Ca", "5Co", "6Pi", "4Pi", "2Tr")));
        assertEquals(6, hand5.isStraight(hand5.getHand()));

    }

}
