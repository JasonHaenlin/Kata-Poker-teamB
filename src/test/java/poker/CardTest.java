package poker;

import org.junit.Test;

import static org.junit.Assert.*;

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

}