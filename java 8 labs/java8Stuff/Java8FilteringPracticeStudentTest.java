import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2019 Java 8 mapping
 */
public class Java8FilteringPracticeStudentTest extends junit.framework.TestCase
{
    public void testJava8FilteringPractice01()
    {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(new Integer (10));
        numbers.add(new Integer (-11));
        numbers.add(new Integer (20));

        List<Integer> result = Java8FilteringPractice.noNeg(numbers);
        assertEquals(2, result.size());
        assertEquals(10, result.get(0).intValue());
        assertEquals(20, result.get(1).intValue());

        numbers = new ArrayList<Integer>();
        numbers.add(new Integer (10));
        numbers.add(new Integer (13));
        numbers.add(new Integer (57));

        result = Java8FilteringPractice.noMatchDigit(numbers, 3);
        assertEquals(2, result.size());
        assertEquals(10, result.get(0).intValue());
        assertEquals(57, result.get(1).intValue());


        numbers = new ArrayList<Integer>();
        numbers.add(new Integer (10));
        numbers.add(new Integer (13));
        numbers.add(new Integer (57));

        result = Java8FilteringPractice.noEven(numbers, 3);
        assertEquals(2, result.size());
        assertEquals(13*3, result.get(0).intValue());
        assertEquals(57*3, result.get(1).intValue());

        List<String> words = new ArrayList<String>();
        words.add("123");
        words.add("1234");
        words.add("12345");
        words.add("123456");

        List<String> sResult = Java8FilteringPractice.playWithStringLengths(words, 4);
        assertEquals(1, sResult.size());
        assertEquals("123456", sResult.get(0));

        words = new ArrayList<String>();
        words.add("The");
        words.add("word");
        words.add("is");
        words.add("Computer");

        sResult = Java8FilteringPractice.playWithStrings(words, "r");
        assertEquals(2, sResult.size());
        assertEquals("Theth", sResult.get(0));
        assertEquals("isth", sResult.get(1));

        words = new ArrayList<String>();
        words.add("wi");
        words.add("bandwid");
        words.add("zeni");

        sResult = Java8FilteringPractice.playWithStrings(words, "ith");
        assertEquals(1, sResult.size());
        assertEquals("bandwidth", sResult.get(0));
    }
}