package poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CardTest {

    @Test
    public void cardTest() {
        try {
            Card card = new Card(1);
            fail("should have failed");
        } catch (Exception e) {
        }
        try {
            Card card = new Card(5);
        } catch (Exception e) {
            fail("should have passed");
        }
    }

    @Test
    public void CardObjTest() throws Exception {
        Card card1 = new Card(14);
        Card card2 = new Card(14);
        Card card3 = new Card(7);

        assertEquals(card1, card2);
        assertTrue(card1.equals(card2));
        assertFalse(card1.equals(card3));
    }

}