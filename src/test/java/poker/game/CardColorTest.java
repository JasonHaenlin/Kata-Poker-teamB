package poker.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * CardColorTest
 */
public class CardColorTest {

    @Test
    public void colorStringToEnumTest() {
        assertEquals("Trefle", CardColor.getEnum("Tr").toString());
        assertEquals("Coeur", CardColor.getEnum("Co").toString());
        assertEquals("Pique", CardColor.getEnum("Pi").toString());
        assertEquals("Carre", CardColor.getEnum("Ca").toString());
    }

    @Test
    public void colorExceptionTest() {
        try {
            CardColor.getEnum("iroiro");
            fail("A wrong color should have stop the program");
        } catch (Exception e) {
        }
    }
}