package poker.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HandTest {

    Hand hand, hand1, hand2, hand3, hand4, hand5, hand6, hand7;

    @Before
    public void setUp() {

        hand = new Hand(1);

        hand1 = new Hand(1);
        hand2 = new Hand(1);
        hand3 = new Hand(1);
        hand4 = new Hand(1);
        hand5 = new Hand(1);
        hand6 = new Hand(1);
        hand7 = new Hand(1);

    }

    @Test
    public void goodNumberOfCardsInHandTest() {
        // 5 cards !
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Ca", "DCa", "5Tr", "6Tr")));
        } catch (Exception e) {
            fail("This test should have passed");
        }
    }

    @Test
    public void notEnoughCardsInHandTest() {
        // 4 cards .... nop
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "DCa", "5Ca", "6Pi")));
            fail("This test should have failed");
        } catch (Exception e) {
        }
    }

    @Test
    public void tooMuchCardsInHandTest() {
        // 6 cards ... it's too much for our game
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "DCa", "5Co", "6Co", "7Co", "10Ca")));
            fail("This test should have failed");
        } catch (Exception e) {
        }
    }

    @Test
    public void noCardsInHandTest() {
        // well ... don't play it's the same
        try {
            hand.buildNewHand(new ArrayList<>(Arrays.asList()));
            fail("This test should have failed");
        } catch (Exception e) {
        }
    }

    @Test
    public void testPair() {
        // pair in hand
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "DCa", "5Co", "6Pi")));
        assertEquals(true, hand1.isPairDetected());
        assertEquals(7, hand1.getPatternValue().getValue());
        /// no pair in hand
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "5Co", "6Pi")));
        assertEquals(false, hand2.isPairDetected());
        // other pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "9Ca", "DCa", "8Pi", "8Tr")));
        assertEquals(true, hand5.isPairDetected());
        assertEquals(8, hand5.getPatternValue().getValue());
    }

    @Test
    public void testThreeOfAKind() {
        // not a ThreeOfAkind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Pi", "DCa", "5Co", "6Pi")));
        assertEquals(false, hand1.isThreeOfAKindDetected());
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "5Co", "6Pi")));
        assertEquals(false, hand2.isThreeOfAKindDetected());
        // a ThreeOfAKind is present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "7Ca", "7Pi")));
        assertEquals(true, hand3.isThreeOfAKindDetected());
        assertEquals(7, hand3.getPatternValue().getValue());
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "DCa", "8Tr", "8Ca")));
        assertEquals(false, hand5.isThreeOfAKindDetected());
    }

    @Test
    public void testFourOfAKind() {
        // not a FourOfAKind just a pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Ca", "7Tr", "DCa", "5Co", "6Pi")));
        assertEquals(false, hand1.isFourOfAKindDetected());
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "5Co", "6Pi")));
        assertEquals(false, hand2.isFourOfAKindDetected());
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "4Pi", "DCa", "7Pi", "7Ca")));
        assertEquals(false, hand3.isFourOfAKindDetected());
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7Co", "7Ca", "DCa", "7Tr", "7Pi")));
        assertEquals(true, hand4.isFourOfAKindDetected());
        assertEquals(7, hand4.getPatternValue().getValue());
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Co", "DCa", "8Co", "8Tr")));
        assertEquals(false, hand5.isFourOfAKindDetected());
    }

    @Test
    public void testFull() {
        //Test avec une pair
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("7Co", "7Tr", "10Pi", "VTr", "DCa")));
        assertEquals(false, hand1.isFullDetected());
        //Test avec brelan
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("7Co", "7Ca", "7Tr", "5Co", "6Pi")));
        assertEquals(false, hand2.isFullDetected());
        //Test full 7 par les 8
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "7Pi", "8Ca", "8Tr")));
        assertEquals(true, hand3.isFullDetected());
        assertEquals(7, hand3.getPatternValue().getValue());
        assertEquals(8, hand3.getPatternValueExtra().getValue());
        //Test full 8 par les 7
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "8Ca", "8Pi", "8Tr")));
        assertEquals(true, hand4.isFullDetected());
        assertEquals(8, hand4.getPatternValue().getValue());
        assertEquals(7, hand4.getPatternValueExtra().getValue());
        //Test avec carree
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Ca", "7Co", "7Pi", "8Tr")));
        assertEquals(false, hand5.isFullDetected());
        //Test avec pair
        hand6.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Pi", "9Ca", "VTr", "10Pi")));
        assertEquals(false, hand6.isFullDetected());
        // Test double pair
        hand7.buildNewHand(new ArrayList<>(Arrays.asList("7Tr", "7Pi", "9Ca", "9Pi", "10Pi")));
        assertEquals(false, hand7.isFullDetected());
    }

    @Test
    public void testStraight() {
        // Not a straight
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("3Ca", "7Tr", "DCa", "5Co", "6Pi")));
        assertEquals(false, hand1.isStraight());
        // nothing in the hand (just highest card)
        hand2.buildNewHand(new ArrayList<>(Arrays.asList("DCa", "ATr", "RCo", "2Tr", "3Ca")));
        assertEquals(false, hand2.isStraight());
        // a FourOfAKind is not present
        hand3.buildNewHand(new ArrayList<>(Arrays.asList("ATr", "4Pi", "2Tr", "5Co", "3Ca")));
        assertEquals(true, hand3.isStraight());
        assertEquals(5, hand3.getPatternValue().getValue());
        // bingo !
        hand4.buildNewHand(new ArrayList<>(Arrays.asList("VTr", "RCo", "ATr", "DCa", "10Pi")));
        assertEquals(true, hand4.isStraight());
        assertEquals(14, hand4.getPatternValue().getValue());
        // just Two pair
        hand5.buildNewHand(new ArrayList<>(Arrays.asList("3Ca", "5Co", "6Pi", "4Pi", "2Tr")));
        assertEquals(true, hand5.isStraight());
        assertEquals(6, hand5.getPatternValue().getValue());
    }

    @Test
    public void testColor() {
        hand1.buildNewHand(new ArrayList<>(Arrays.asList("3Ca", "4Ca", "10Ca", "ACa", "RCa")));
        assertEquals(true, hand1.isColorDetected());
        assertEquals(CardColor.SQUARE, hand1.getPatternColor());

        hand2.buildNewHand(new ArrayList<>(Arrays.asList("3Ca", "4Co", "10Ca", "ACa", "RCa")));
        assertEquals("1 false", false, hand2.isColorDetected());

        hand3.buildNewHand(new ArrayList<>(Arrays.asList("3Ca", "4Ca", "10Ca", "ACa", "RTr")));
        assertEquals("2 false", false, hand3.isColorDetected());

        hand4.buildNewHand(new ArrayList<>(Arrays.asList("3Tr", "4Ca", "10Ca", "ACa", "RCa")));
        assertEquals("3 false", false, hand4.isColorDetected());
    }

}
