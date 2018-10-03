package poker.game;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectionTest {

    Hand hand1, hand2, hand3, hand4, hand5, hand6, hand7;
    Detection detection;

    @Before
    public void setUp() {
        detection = new Detection();

        hand1 = new Hand(1);
        hand2 = new Hand(1);
        hand3 = new Hand(1);
        hand4 = new Hand(1);
        hand5 = new Hand(1);
        hand6 = new Hand(1);
        hand7 = new Hand(1);

    }

    @Test
    public void testPair() {
        // pair in hand
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(7, detection.isPairDetected(hand1.getHand()));
        /// no pair in hand
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, detection.isPairDetected(hand2.getHand()));
        // other pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "9", "12", "8", "8")));
        assertEquals(8, detection.isPairDetected(hand5.getHand()));
    }

    @Test
    public void testThreeOfAKind() {
        // not a ThreeOfAkind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, detection.isTreeOfAKindDetected(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, detection.isTreeOfAKindDetected(hand2.getHand()));
        // a ThreeOfAKind is present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(7, detection.isTreeOfAKindDetected(hand3.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, detection.isTreeOfAKindDetected(hand5.getHand()));
    }

    @Test
    public void testFourOfAKind() {
        // not a FourOfAKind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, detection.isFourOfAKindDetected(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, detection.isFourOfAKindDetected(hand2.getHand()));
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(-1, detection.isFourOfAKindDetected(hand3.getHand()));
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(7, detection.isFourOfAKindDetected(hand4.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, detection.isFourOfAKindDetected(hand5.getHand()));
    }

    @Test
    public void testFull() {
        //Test avec une pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "10", "11", "12")));
        assertArrayEquals(new int[]{-1, -1}, detection.isFullDetected(hand1.getHand()));
        //Test avec brelan
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "7", "5", "6")));
        assertArrayEquals(new int[]{-1, -1}, detection.isFullDetected(hand2.getHand()));
        //Test full 7 par les 8
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "7", "8", "8")));
        assertArrayEquals(new int[]{7, 8}, detection.isFullDetected(hand3.getHand()));
        //Test full 8 par les 7
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "8", "8", "8")));
        assertArrayEquals(new int[]{8, 7}, detection.isFullDetected(hand4.getHand()));
        //Test avec carree
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "7", "7", "8")));
        assertArrayEquals(new int[]{-1, -1}, detection.isFullDetected(hand5.getHand()));
        //Test avec pair
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "9", "11", "10")));
        assertArrayEquals(new int[]{-1, -1}, detection.isFullDetected(hand6.getHand()));
        // Test double pair
        hand7.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "9", "9", "10")));
        assertArrayEquals(new int[]{-1, -1}, detection.isFullDetected(hand7.getHand()));
    }

    @Test
    public void testStraight() {
        // Not a straight
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("3", "7", "12", "5", "6")));
        assertEquals(-1, detection.isStraight(hand1.getHand()));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("12", "14", "13", "2", "3")));
        assertEquals(-1, detection.isStraight(hand2.getHand()));
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("14", "4", "2", "5", "3")));
        assertEquals(5, detection.isStraight(hand3.getHand()));
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("11", "13", "14", "12", "10")));
        assertEquals(14, detection.isStraight(hand4.getHand()));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("3", "5", "6", "4", "2")));
        assertEquals(6, detection.isStraight(hand5.getHand()));

    }
}
