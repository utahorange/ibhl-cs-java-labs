import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2019 Java 8 mapping
 */
public class Java8ReplaceAllPracticeStudentTest extends junit.framework.TestCase
{
    public void testJava8ReplaceAllPractice01()
    {
        List<Integer> num1 = new ArrayList<Integer>();
        num1.add(new Integer (5));
        List<Integer> result = Java8ReplaceAllPractice.doubleIt(num1);
        assertEquals(10, result.get(0).intValue());
        assertEquals(1, result.size());

        List<Integer> num2 = new ArrayList<Integer>();
        num2.add(new Integer (17));
        result = Java8ReplaceAllPractice.squareOnePlaceValue(num2);
        assertEquals(7*7, result.get(0).intValue());
        assertEquals(1, result.size());

        List<Integer> num3 = new ArrayList<Integer>();
        num3.add(new Integer (5));
        result = Java8ReplaceAllPractice.subtract_that(num3, 2);
        assertEquals(5-2, result.get(0).intValue());
        assertEquals(1, result.size());

        List<String> w1 = new ArrayList<String>();
        w1.add("foo");
        List<String> res = Java8ReplaceAllPractice.surroundWordWith_phrase(w1, "*#");
        assertEquals("*#foo*#", res.get(0));
        assertEquals(1, res.size());

        List<String> w2 = new ArrayList<String>();
        w2.add("foo");
        res = Java8ReplaceAllPractice.stickWordsInMiddleOfPhrase(w2, "12345");
        assertEquals("123foo45", res.get(0));
        assertEquals(1, res.size());

        List<String> w3 = new ArrayList<String>();
        w3.add("ax");
        w3.add("bb");
        w3.add("xcx");
        res = Java8ReplaceAllPractice.removePhrase(w3, "x");
        assertEquals(3, res.size());
        assertEquals("a", res.get(0));
        assertEquals("bb", res.get(1));
        assertEquals("c", res.get(2));

        w3 = new ArrayList<String>();
        w3.add("mississippi");
        w3.add("passes");
        w3.add("stop");
        res = Java8ReplaceAllPractice.removePhrase(w3, "ss");
        assertEquals(3, res.size());
        assertEquals("miiippi", res.get(0));
        assertEquals("paes", res.get(1));
        assertEquals("stop", res.get(2));

        w3 = new ArrayList<String>();
        w3.add("please");
        res = Java8ReplaceAllPractice.removePhrase(w3, "please");
        assertEquals(1, res.size());
        assertEquals("", res.get(0));
    }
}