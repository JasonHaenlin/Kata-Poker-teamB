package poker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RefereeTest {

    @Test
    public void winnerTest() {
        Referee referee = new Referee();
        Hand hand1 = new Hand(1);
        Hand hand2 = new Hand(2);
        Hand hand3 = new Hand(1);
        Hand hand4 = new Hand(2);

        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "7", "9", "10")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("14", "8", "2", "11", "12")));
        assertEquals(1, referee.winner(hand1, hand2));   //La main 1 doit gagner avec une paire

        assertEquals(2, referee.winner(hand2, hand1));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("14", "8", "2", "14", "12")));
        assertEquals(0, referee.winner(hand1, hand3));//Les deux mains ont une paire
        assertEquals(0, referee.winner(hand1, hand1));
        assertEquals(0, referee.winner(hand2, hand2));

        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "7", "9", "7")));
        assertEquals(1, referee.winner(hand4, hand2));//La main 4 gagne avec un brelan face à rien
        assertEquals(2, referee.winner(hand2, hand4));

        assertEquals(1, referee.winner(hand4, hand1));//La main 4 gagne sur une paire
        assertEquals(2, referee.winner(hand1, hand4));

        assertEquals(0, referee.winner(hand4, hand4));
    }
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
    @Test public void testBrelan() {
        Referee Referee = new Referee();
        Hand hand1 = new Hand(1);
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, Referee.findBrelan(hand1));

        Hand hand2 = new Hand(1);
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, Referee.findBrelan(hand2));

        Hand hand3 = new Hand(1);
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(7, Referee.findBrelan(hand3));

        Hand hand4 = new Hand(1);
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(-1, Referee.findBrelan(hand4));

        Hand hand5 = new Hand(1);
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, Referee.findBrelan(hand5));


    }

    @Test public void testSquare() {
        Referee Referee = new Referee();
        Hand hand1 = new Hand(1);
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "5", "6")));
        assertEquals(-1, Referee.findSquare(hand1));

        Hand hand2 = new Hand(1);
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "5", "6")));
        assertEquals(-1, Referee.findSquare(hand2));

        Hand hand3 = new Hand(1);
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "7", "7")));
        assertEquals(-1, Referee.findSquare(hand3));

        Hand hand4 = new Hand(1);
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "7", "7")));
        assertEquals(7, Referee.findSquare(hand4));

        Hand hand5 = new Hand(1);
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7", "7", "12", "8", "8")));
        assertEquals(-1, Referee.findSquare(hand5));

    }

}
