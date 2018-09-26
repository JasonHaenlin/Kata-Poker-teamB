package poker;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class WinnerTest {

	Hand hand1, hand2;
	Referee referee;

	@Before
	public void setUp() {
		referee = new Referee();

		hand1 = new Hand(1);
		hand2 = new Hand(2);
	}

	@Test
	public void winnerFirstHandTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("14", "8", "2", "14", "12")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "7", "9", "10")));
		assertEquals(1, referee.winner(hand1, hand2));
	}

	@Test
	public void winnerSecondHandTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "12", "9", "9")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("9", "8", "2", "8", "14")));
		assertEquals(2, referee.winner(hand1, hand2));
	}

	@Test
	public void equalityHandTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "14", "9", "9")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "14", "9", "9")));
		assertEquals(0, referee.winner(hand1, hand2));
	}
}
