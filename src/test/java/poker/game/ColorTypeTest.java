package poker.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * ColorTypeTest
 */
public class ColorTypeTest {

    @Test
    public void ColorStringToEnumTest() {
        assertEquals("Trefle", ColorType.getEnum("Tr").toString());
        assertEquals("Coeur", ColorType.getEnum("Co").toString());
        assertEquals("Pique", ColorType.getEnum("Pi").toString());
        assertEquals("Carre", ColorType.getEnum("Ca").toString());
    }

    @Test
    public void ColorExceptionTest() {
        try {
            ColorType.getEnum("iroiro");
            fail("A wrong color should have stop the program");
        } catch (Exception e) {
        }
    }
}