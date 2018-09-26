package poker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;



public class RefereeTest {
    @Test public void testPair() {
        Referee Referee = new Referee();
        Hand hand1 = new Hand(1);
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(7, Referee.findPair(hand1));

        Hand hand2 = new Hand(1);
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, Referee.findPair(hand2));

        Hand hand3 = new Hand(1);
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(-1, Referee.findPair(hand3));

        Hand hand4 = new Hand(1);
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(-1, Referee.findPair(hand4));

        Hand hand5 = new Hand(1);
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(7, Referee.findPair(hand5));


    }
    @Test public void testTriple() {
        Referee Referee = new Referee();
        Hand hand1 = new Hand(1);
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, Referee.findTriple(hand1));

        Hand hand2 = new Hand(1);
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, Referee.findTriple(hand2));

        Hand hand3 = new Hand(1);
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(7, Referee.findTriple(hand3));

        Hand hand4 = new Hand(1);
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(-1, Referee.findTriple(hand4));

        Hand hand5 = new Hand(1);
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, Referee.findTriple(hand5));


    }

    @Test public void testFourOfAKind() {
        Referee Referee = new Referee();
        Hand hand1 = new Hand(1);
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, Referee.findFourOfAKind(hand1));

        Hand hand2 = new Hand(1);
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, Referee.findFourOfAKind(hand2));

        Hand hand3 = new Hand(1);
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(-1, Referee.findFourOfAKind(hand3));

        Hand hand4 = new Hand(1);
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(7, Referee.findFourOfAKind(hand4));

        Hand hand5 = new Hand(1);
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, Referee.findFourOfAKind(hand5));


    }

}
