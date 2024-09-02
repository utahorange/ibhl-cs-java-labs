import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentBongardTest extends junit.framework.TestCase
{
    public void testBongard01()
    {
        assertEquals(3, Bongard.getNumTallLetters("BIOETHIC"));
        assertEquals(4, Bongard.getNumTallLetters("BALLET"));

        assertEquals(1, Bongard.getNumVowels("GULLY"));
        assertEquals(3, Bongard.getNumVowels("ASTRONOMY"));

        assertEquals(2, Bongard.getNumVowelsWithY("GULLY"));
        assertEquals(4, Bongard.getNumVowelsWithY("ASTRONOMY"));

        assertEquals("URT", Bongard.endsWith("COURT"));
        assertEquals("AT", Bongard.endsWith("AT"));

        assertEquals("COM", Bongard.startsWith("COMET"));
        assertEquals("AT", Bongard.startsWith("AT"));

        assertEquals(true, Bongard.getPlusMinus("PROGRAMMER") < 0);
        assertEquals(true, Bongard.getPlusMinus("EMAIL") > 0);
        assertEquals(true, Bongard.getPlusMinus("FUTURE") == 0);

        assertEquals(6, Bongard.getLength("FUTURE"));
        assertEquals(2, Bongard.getLength("AT"));

        String[] left1 = {"BATH", "THAT"};
        String[] right1 = {"ARID", "HAIR"};
        Bongard bon1 = new Bongard(left1, right1);
        assertEquals("RIGHT", bon1.whichBox("LOVE"));
        assertEquals("LEFT", bon1.whichBox("HALT"));
        assertEquals("NEITHER", bon1.whichBox("ANGEL"));

        String[] left2 = {"LEAVE", "ALONE", "HOUSE", "ABOVE", "MEDIA"};
        String[] right2 = {"FAMILY", "GALAXY", "HOCKEY", "MONKEY", "MONEY", "GOODY"};
        Bongard bon2 = new Bongard(left2, right2);
        assertEquals("RIGHT", bon2.whichBox("NOWAY"));
        assertEquals("LEFT", bon2.whichBox("RADIO"));
        assertEquals("NEITHER", bon2.whichBox("ANIMAL"));
    }
}