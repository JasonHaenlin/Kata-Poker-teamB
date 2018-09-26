package poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CardTest {

    @Test
    public void cardTest() {
        // cards between 2 and 14 included
        try {
            new Card(1);
            fail("should have failed");
        } catch (Exception e) {
        }
        try {
            new Card(5);
        } catch (Exception e) {
            fail("should have passed");
        }
    }

    @Test
    public void CardObjTest() throws Exception {
        Card card1 = new Card(14);
        Card card2 = new Card(14);
        Card card3 = new Card(7);

        // same references, because same value
        assertEquals(card1, card2);
        assertTrue(card1.equals(card2));

        // not the same references
        assertFalse(card1.equals(card3));
    }

}