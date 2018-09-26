package poker;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class WinnerTest {

	@Test
	public void winnerTest() {
		Referee referee = new Referee();
		Hand hand1 = new Hand(1);
		Hand hand2 = new Hand(2);
		Hand hand3 = new Hand(1);
		Hand hand4 = new Hand(2);

		hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "7", "9", "10")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("14", "8", "2", "14", "12")));
		assertEquals(2, referee.winner(hand1, hand2)); // victoire de la main2

		hand3.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "14", "9", "9")));
		hand4.buildNewHand(new ArrayList<>(Arrays.asList("9", "8", "2", "8", "12")));
		assertEquals(1, referee.winner(hand3, hand4)); // victoire de la main2

		assertEquals(0, referee.winner(hand1, hand1)); // égalité
	}
}
