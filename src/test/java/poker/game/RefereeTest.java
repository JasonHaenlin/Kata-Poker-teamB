package poker.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import poker.game.exception.CardDuplicationBetweenPlayerRuntimeException;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RefereeTest {

    Hand hand1, hand2, hand3, hand4, hand5, hand6;
    Referee referee;

    @Before
    public void setUp() {
        referee = new Referee();

        hand1 = new Hand(1);
        hand2 = new Hand(2);
        hand3 = new Hand(3);
        hand4 = new Hand(4);
        hand5 = new Hand(5);
        hand6 = new Hand(6);
    }

    @Test
    public void duplicatedCardsBetweenHands() {
        // cards are unique... don't copy the other hand
        try {
            this.hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Co", "3Ca", "7Pi", "4Co", "9Tr")));
            this.hand2.buildNewHand(new ArrayList<>(Arrays.asList("10Tr", "VTr", "DTr", "RTr", "9Tr")));

            referee.checkForDuplicateCards(hand1, hand2);
            fail("This test should have failed");
        } catch (CardDuplicationBetweenPlayerRuntimeException e) {
        }
    }

    @Test
    public void winnerStraightFlushTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Tr", "6Tr", "7Tr", "8Tr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("9Tr", "10Tr", "VTr", "DTr", "RTr")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("ACo", "2Co", "3Co", "4Co", "5Co")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("APi", "2Pi", "3Pi", "4Pi", "5Pi")));

        assertEquals(0, referee.establishTheWinner(hand3, hand4));

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("6Pi", "2Pi", "3Pi", "4Pi", "5Pi")));
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("ACo", "2Co", "3Co", "4Co", "5Co")));

        assertEquals(5, referee.establishTheWinner(hand5, hand6));

    }

    @Test
    public void winnerAdvancedCombinationStrenghtTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "4Pi", "4Ca", "9Ca", "9Co")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "ACo", "APi", "RCo", "VTr")));

        assertEquals(1, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("3Tr", "4Pi", "5Ca", "6Ca", "7Co")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("10Tr", "VCo", "DPi", "RCo", "ATr")));

        assertEquals(4, referee.establishTheWinner(hand3, hand4));

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "2Pi", "3Ca", "4Co", "5Co")));
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("5Tr", "6Co", "7Pi", "8Co", "9Tr")));

        assertEquals(6, referee.establishTheWinner(hand5, hand6));
    }

    @Test
    public void winnerColorCombinationTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Tr", "7Tr", "9Tr", "10Tr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "VTr", "RTr", "3Tr", "DTr")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("4Ca", "5Ca", "10Ca", "9Ca", "ACa")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "6Co", "VPi", "VCo", "VTr")));

        assertEquals(3, referee.establishTheWinner(hand3, hand4));

    }

    @Test
    public void winnerMulipleCardResultValueTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Pi", "6Pi", "9Ca", "10Co")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("3Tr", "5Co", "6Ca", "9Co", "10Tr")));

        assertEquals(1, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "4Pi", "4Ca", "9Ca", "10Co")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "6Co", "VPi", "VCo", "VTr")));

        assertEquals(4, referee.establishTheWinner(hand3, hand4));
    }

    @Test
    public void winnerSameCombinationTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "4Pi", "6Pi", "9Ca", "10Co")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "ACo", "2Pi", "VCo", "DTr")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "4Pi", "4Ca", "9Ca", "10Co")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "6Co", "VPi", "VCo", "VTr")));

        assertEquals(4, referee.establishTheWinner(hand3, hand4));

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "4Pi", "9Ca", "9Co", "10Co")));
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("4Ca", "4Co", "10Pi", "10Tr", "VTr")));

        assertEquals(6, referee.establishTheWinner(hand5, hand6));
    }

    @Test
    public void winnerHighestCardtest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Pi", "6Pi", "9Ca", "10Co")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "8Co", "2Pi", "VCo", "DTr")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Pi", "6Pi", "9Ca", "10Co")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("3Tr", "5Co", "6Ca", "9Co", "VTr")));

        assertEquals(4, referee.establishTheWinner(hand3, hand4));
    }

    @Test
    public void winnerBasicCombinationTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Pi", "4Pi", "9Ca", "10Co")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "8Co", "2Pi", "VCo", "DTr")));

        assertEquals(1, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("3Tr", "5Co", "6Ca", "9Co", "VTr")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Pi", "4Pi", "9Ca", "10Co")));

        assertEquals(4, referee.establishTheWinner(hand3, hand4));

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("6Co", "2Co", "3Co", "4Co", "5Co")));
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "ACo", "ACa", "9Co", "APi")));

        assertEquals(5, referee.establishTheWinner(hand5, hand6));

    }

    @Test
    public void winnerEqualityCombinationTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "4Co", "4Pi", "9Ca", "9Co")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("RTr", "RCo", "RPi", "VCo", "VTr")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "4Co", "6Pi", "6Ca", "9Co")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("4Ca", "4Pi", "5Pi", "5Co", "VTr")));

        assertEquals(3, referee.establishTheWinner(hand3, hand4));

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("6Tr", "6Pi", "9Ca", "9Co", "ACo")));
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("6Ca", "6Co", "9Pi", "9Tr", "VTr")));

        assertEquals(5, referee.establishTheWinner(hand5, hand6));
    }

    @Test
    public void advancedEqualityTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "RTr", "7Tr", "9Tr", "10Tr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("4Ca", "RCa", "7Ca", "9Ca", "10Ca")));

        assertEquals(0, referee.establishTheWinner(hand1, hand2));

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("4Tr", "5Tr", "6Tr", "7Tr", "8Tr")));
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("4Ca", "5Ca", "6Ca", "7Ca", "8Ca")));

        assertEquals(0, referee.establishTheWinner(hand3, hand4));

        hand5.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "2Pi", "3Ca", "4Co", "5Co")));
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("ACa", "2Tr", "3Tr", "4Pi", "5Tr")));

        assertEquals(0, referee.establishTheWinner(hand5, hand6));
    }

    @Test
    public void tresholdCoefScoreHighToPairTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("9Tr", "VTr", "DCa", "RCo", "ATr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("2Tr", "2Ca", "3Ca", "4Ca", "5Ca")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));
    }

    @Test
    public void tresholdCoefScorePairToTwoPairTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "ACo", "RTr", "DTr", "VTr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("2Ca", "2Co", "3Ca", "3Co", "4Tr")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));
    }

    @Test
    public void tresholdCoefScoreTwoPairToThreeOfAKindTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "ACo", "RTr", "RCo", "DTr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("2Ca", "2Co", "2Tr", "3Ca", "4Ca")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));
    }

    @Ignore
    @Test
    public void tresholdCoefScoreThreeOfAKindToStraightTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "ACo", "ACa", "RTr", "VTr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("APi", "2Ca", "3Ca", "4Co", "5Ca")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));
    }

    @Ignore
    @Test
    public void tresholdCoefScoreStraightToColorTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("10Pi", "VCo", "DCa", "RTr", "ATr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("2Ca", "3Ca", "4Ca", "5Ca", "7Ca")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));
    }

    @Test
    public void tresholdCoefScoreColorToFullTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("9Pi", "VPi", "DPi", "RPi", "APi")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("2Ca", "2Co", "2Pi", "3Ca", "3Co")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));
    }

    @Test
    public void tresholdCoefScoreFullToFourOfAKindTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "ACa", "ACo", "RTr", "RPi")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("2Ca", "2Tr", "2Co", "2Pi", "3Ca")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));
    }

    @Test
    public void tresholdCoefScoreFourOfAKindToQuinteFlushTest() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "APi", "ACo", "ACa", "RTr")));
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("6Ca", "2Ca", "3Ca", "4Ca", "5Ca")));

        assertEquals(2, referee.establishTheWinner(hand1, hand2));
    }
}
