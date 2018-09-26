package poker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RefereeTest {

    Hand hand1, hand2, hand3, hand4, hand5;
    Referee referee;

    @Before
    public void setUp() {
        referee = new Referee();

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
        assertEquals(7, referee.findPair(hand1));
        /// no pair in hand
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, referee.findPair(hand2));
        // threeOfAKind so not a pair
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(-1, referee.findPair(hand3));
        // FourOfAKind so not a pair
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(-1, referee.findPair(hand4));
        // Two pair so not a pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(7, referee.findPair(hand5));
    }

    @Test
    public void testThreeOfAKind() {
        // not a ThreeOfAkind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, referee.findTriple(hand1));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, referee.findTriple(hand2));
        // a ThreeOfAKind is present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(7, referee.findTriple(hand3));
        /// a FourOfAKind not a ThreeOfAKind
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(-1, referee.findTriple(hand4));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, referee.findTriple(hand5));
    }

    @Test
    public void testFourOfAKind() {
        // not a FourOfAKind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, referee.findFourOfAKind(hand1));
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, referee.findFourOfAKind(hand2));
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(-1, referee.findFourOfAKind(hand3));
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(7, referee.findFourOfAKind(hand4));
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, referee.findFourOfAKind(hand5));
    }

}
