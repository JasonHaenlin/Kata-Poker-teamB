package poker.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * CardValueTest
 */
public class CardValueTest {

    @Test
    public void valueStringToEnumTest() {
        assertEquals("2", CardValue.getEnum("2").toString());
        assertEquals("10", CardValue.getEnum("10").toString());
        assertEquals("Valet", CardValue.getEnum("V").toString());
        assertEquals("Dame", CardValue.getEnum("D").toString());
        assertEquals("Roi", CardValue.getEnum("R").toString());
        assertEquals("As", CardValue.getEnum("A").toString());
    }

    @Test
    public void valueExceptionTest() {
        try {
            CardValue.valueOf("1");
            fail("1 is not a correct value, should have failed");
        } catch (Exception e) {
        }
    }
}