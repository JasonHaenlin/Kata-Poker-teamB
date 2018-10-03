package poker.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

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
    public void winnerTest() {

        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "7", "9", "10")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("14", "8", "2", "11", "12")));
        //La main 1 doit gagner avec une paire
        assertEquals(1, winner(hand1, hand2));

        assertEquals(2, winner(hand2, hand1));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("14", "8", "2", "14", "12")));
        //Les deux mains ont une paire
        assertEquals(0, winner(hand1, hand3));
        assertEquals(0, winner(hand1, hand1));
        assertEquals(0, winner(hand2, hand2));

        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "7", "9", "7")));
        //La main 4 gagne avec un brelan face à rien
        assertEquals(1, winner(hand4, hand2));
        assertEquals(2, winner(hand2, hand4));
        //La main 4 gagne sur une paire
        assertEquals(1, winner(hand4, hand1));
        assertEquals(2, winner(hand1, hand4));

        assertEquals(0, winner(hand4, hand4));
    }

    private int winner(Hand hand1, Hand hand2) {
        referee.checkHandsCombination(hand1, hand2);
        return referee.establishTheWinner(hand1, hand2);
    }

}
