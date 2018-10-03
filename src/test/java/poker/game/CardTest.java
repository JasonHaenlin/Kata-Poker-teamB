package poker.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CardTest {

    @Test
    public void cardTest() {
        try {
            new Card(CardValue.getEnum("1"), CardColor.SPADE);
            fail("should have failed");
        } catch (Exception e) {
        }

        try {
            new Card(CardValue.C_3, CardColor.getEnum("ir"));
            fail("should have failed");
        } catch (Exception e) {
        }

        try {
            new Card(CardValue.getEnum("5"), CardColor.getEnum("Tr"));
        } catch (Exception e) {
            fail("should have passed");
        }
    }

    @Test
    public void CardObjTest() {
        Card card1 = new Card(CardValue.C_10, CardColor.HEART);
        Card card2 = new Card(CardValue.C_10, CardColor.HEART);
        Card card3 = new Card(CardValue.C_3, CardColor.HEART);

        // same references, because same value
        assertEquals(card1, card2);
        assertTrue(card1.equalsValue(card2));

        // not the same references
        assertFalse(card1.equalsValue(card3));
    }

}