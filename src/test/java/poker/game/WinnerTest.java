package poker.game;

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
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "6", "9", "10")));
		assertEquals(1, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void winnerSecondHandTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "6", "5", "9")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("9", "8", "2", "8", "14")));
		assertEquals(2, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void equalityHandTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "14", "9", "9")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "14", "9", "9")));
		assertEquals(0, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void winnerPairTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("11", "8", "2", "14", "11")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "6", "9", "10")));
		assertEquals(1, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void winnerThreeOfAKindTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("11", "8", "2", "14", "11")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "4", "4", "10")));
		assertEquals(2, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void winnerFourOfAKindTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("10", "10", "10", "10", "11")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7", "4", "6", "9", "10")));
		assertEquals(1, referee.establishTheWinner(hand1, hand2));
	}
}
