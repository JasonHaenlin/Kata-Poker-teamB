package poker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RefereeTest {

    @Test
    public void refereeTest()
    {
        Referee referee = new Referee();
        Hand hand1 = new Hand(1);
        Hand hand2 = new Hand(2);
        Hand hand3 = new Hand(1);
        Hand hand4 = new Hand(2);

        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "7", "9", "10")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("14", "8", "2", "11", "12")));
        assertEquals(1, referee.winner(hand1,hand2));   //La main 1 doit gagner avec une paire

        assertEquals(2, referee.winner(hand2,hand1));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("14", "8", "2", "14", "12")));
        assertEquals(0, referee.winner(hand1,hand3));//Les deux mains ont une paire
        assertEquals(0, referee.winner(hand1,hand1));
        assertEquals(0, referee.winner(hand2,hand2));

        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "7", "9", "7")));
        assertEquals(1, referee.winner(hand4,hand2));//La main 4 gagne avec un brelan face à rien
        assertEquals(2, referee.winner(hand2,hand4));

        assertEquals(1, referee.winner(hand4,hand1));//La main 4 gagne sur une paire
        assertEquals(2, referee.winner(hand1,hand4));

        assertEquals(0, referee.winner(hand4,hand4));
    }

}
