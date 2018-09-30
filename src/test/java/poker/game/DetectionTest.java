package poker.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectionTest {

    Hand hand1, hand2, hand3, hand4, hand5;
    Detection detection;

    @Before
    public void setUp() {
        detection = new Detection();

        hand1 = new Hand(1);
        hand2 = new Hand(1);
        hand3 = new Hand(1);
        hand4 = new Hand(1);
        hand5 = new Hand(1);
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
}
