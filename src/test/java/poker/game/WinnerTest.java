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
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "8Co", "2Pi", "ATr", "DCo")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "6Tr", "9Pi", "10Pi")));
		assertEquals(1, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void winnerSecondHandTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "6Tr", "5Pi", "9Pi")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("9Pi", "8Co", "2Pi", "8Co", "ATr")));
		assertEquals(2, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void equalityHandTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "ATr", "9Pi", "9Pi")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "ATr", "9Pi", "9Pi")));
		assertEquals(0, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void winnerPairTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("VTr", "8Co", "2Pi", "ATr", "VTr")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "6Tr", "9Pi", "10Pi")));
		assertEquals(1, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void winnerThreeOfAKindTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("VTr", "8Co", "2Pi", "ATr", "VTr")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "4Ca", "4Ca", "10Pi")));
		assertEquals(2, referee.establishTheWinner(hand1, hand2));
	}

	@Test
	public void winnerFourOfAKindTest() {
		hand1.buildNewHand(new ArrayList<>(Arrays.asList("10Pi", "10Pi", "10Pi", "10Pi", "VTr")));
		hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "6Tr", "9Pi", "10Pi")));
		assertEquals(1, referee.establishTheWinner(hand1, hand2));
	}
}
