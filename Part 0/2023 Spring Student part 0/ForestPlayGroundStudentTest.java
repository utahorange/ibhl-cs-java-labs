import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2017 Wittry programming contest
 */
public class ForestPlayGroundStudentTest extends junit.framework.TestCase
{
    public void testForestPlayGroundRevisited01()
    {
        int[] figure2 = {-1, 12, 23, 18, 11, 43, 12, 27, 56, 78, -1, -1, 32, 98};
        ForestPlayGroundRevisited t = new ForestPlayGroundRevisited(figure2);

        int[] sol = t.getLevel(3);
        assertEquals(4, sol.length);
        assertEquals(11, sol[0]);
        assertEquals(43, sol[1]);
        assertEquals(12, sol[2]);
        assertEquals(27, sol[3]);

        sol = t.getLevel(4);
        assertEquals(4, sol.length);
        assertEquals(56, sol[0]);
        assertEquals(78, sol[1]);
        assertEquals(32, sol[2]);
        assertEquals(98, sol[3]);

        assertEquals(4, t.getLevelWithHighestAverage());

        sol = t.shiftLevelLeft();
        int[] answer = {-1, 12, 18, 23, 43, 12, 27, 11, 78, 32, -1, -1, 98, 56};
        assertEquals(figure2.length, sol.length);

        for (int s = 0; s < sol.length; s++)
           assertEquals(answer[s], sol[s]);
    }
}