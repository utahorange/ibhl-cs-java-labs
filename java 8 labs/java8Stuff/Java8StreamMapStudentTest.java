import java.util.*;
import kareltherobot.*;
import java.awt.Point;
/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2019 Java 8 mapping
 */
public class Java8StreamMapStudentTest extends junit.framework.TestCase implements Directions
{
    public void testJava8StreamMap01()
    {
        World.setDelay(0);
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(new Integer (10));
        numbers.add(new Integer (-11));
        numbers.add(new Integer (20));

        List<Integer> result = Java8StreamMapCollect.noNeg(numbers);
        assertEquals(2, result.size());
        assertEquals(10, result.get(0).intValue());
        assertEquals(20, result.get(1).intValue());

        assertEquals(3, numbers.size());
        assertEquals(10, numbers.get(0).intValue());
        assertEquals(-11, numbers.get(1).intValue());
        assertEquals(20, numbers.get(2).intValue());

        List<String> words = new ArrayList<String>();
        words.add("one");
        words.add("five");
        words.add("seven");
        words.add("twenty-one");

        List<String> sResult = Java8StreamMapCollect.shortenString(words, 4);
        assertEquals(1, sResult.size());
        assertEquals("wenty-on", sResult.get(0));

        assertEquals(4, words.size());
        assertEquals("one", words.get(0));
        assertEquals("five", words.get(1));
        assertEquals("seven", words.get(2));
        assertEquals("twenty-one", words.get(3));

        words = new ArrayList<String>();
        words.add("one");
        words.add("five");
        words.add("seven");
        words.add("twenty-one");

        sResult = Java8StreamMapCollect.shortenStringAgain(words, 4);
        assertEquals(2, sResult.size());
        assertEquals("eve", sResult.get(0));
        assertEquals("wenty-on", sResult.get(1));

        assertEquals(4, words.size());
        assertEquals("one", words.get(0));
        assertEquals("five", words.get(1));
        assertEquals("seven", words.get(2));
        assertEquals("twenty-one", words.get(3));

        numbers = new ArrayList<Integer>();
        numbers.add(new Integer (7));
        numbers.add(new Integer (11));
        numbers.add(new Integer (2));
        numbers.add(new Integer (5));

        result = Java8StreamMapCollect.multiplyByScalar(numbers, 7);
        assertEquals(3, result.size());
        assertEquals(49, result.get(0).intValue());
        assertEquals(77, result.get(1).intValue());
        assertEquals(14, result.get(2).intValue());

        assertEquals(4, numbers.size());
        assertEquals(7, numbers.get(0).intValue());
        assertEquals(11, numbers.get(1).intValue());
        assertEquals(2, numbers.get(2).intValue());
        assertEquals(5, numbers.get(3).intValue());

        numbers = new ArrayList<Integer>();
        numbers.add(new Integer (7));
        numbers.add(new Integer (11));
        numbers.add(new Integer (-2));
        numbers.add(new Integer (5));

        sResult = Java8StreamMapCollect.convertToString(numbers);
        assertEquals(3, sResult.size());
        assertEquals("7", sResult.get(0));
        assertEquals("11", sResult.get(1));
        assertEquals("5", sResult.get(2));

        assertEquals(4, numbers.size());
        assertEquals(7, numbers.get(0).intValue());
        assertEquals(11, numbers.get(1).intValue());
        assertEquals(-2, numbers.get(2).intValue());
        assertEquals(5, numbers.get(3).intValue());

        words = new ArrayList<String>();
        words.add("123456");
        words.add("123");
        words.add("123456789");

        result = Java8StreamMapCollect.listOfLengths(words, 7);
        assertEquals(2, result.size());
        assertEquals(6, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());

        assertEquals(3, words.size());
        assertEquals("123456", words.get(0));
        assertEquals("123", words.get(1));
        assertEquals("123456789", words.get(2));

        List<IntPoint> p = new ArrayList<IntPoint>();
        p.add(new IntPoint(1, 1));
        p.add(new IntPoint(1, 0));
        p.add(new IntPoint(10, 2));

        List<Robot> botResult = Java8StreamMapCollect.robotMaker(p);
        assertEquals(2, botResult.size());
        assertEquals(true,
            botResult.get(0).toString().indexOf("(street: 1) (avenue: 1) (beepers: 10) ( direction: North)") >=0);            
        assertEquals(true,
            botResult.get(1).toString().indexOf("(street: 10) (avenue: 2) (beepers: 10) ( direction: North)") >=0);            

        assertEquals(3, p.size());
        assertEquals(new IntPoint(1, 1), p.get(0));
        assertEquals(new IntPoint(1, 0), p.get(1));
        assertEquals(new IntPoint(10, 2), p.get(2));

        List<Object> oNums = new ArrayList<Object>();
        oNums.add(new Integer (1));
        oNums.add(new Integer (2));
        oNums.add(new Integer (3));
        oNums.add(new Integer (4));
        oNums.add(new Integer (5));
        oNums.add(new Integer (6));
        oNums.add(new Integer (7));
        oNums.add(new Integer (8));
        oNums.add(new Integer (9));

        Object[] obj = Java8StreamMapCollect.getAsArray(oNums, 7);
        assertEquals(2, obj.length);
        assertEquals(8, ((Integer)obj[0]).intValue());
        assertEquals(9, ((Integer)obj[1]).intValue());

        assertEquals(9, oNums.size());
        assertEquals(1, ((Integer)oNums.get(0)).intValue());
        assertEquals(3, ((Integer)oNums.get(2)).intValue());
        assertEquals(6, ((Integer)oNums.get(5)).intValue());
        assertEquals(8, ((Integer)oNums.get(7)).intValue());
        assertEquals(9, ((Integer)oNums.get(8)).intValue());

        List<Object> oList = new ArrayList<Object>();
        oList.add(new IntPoint(1, 1));
        oList.add(new PointSum(1, 0));
        oList.add(new PointProd(10, 2));
        oList.add(new PointSum(1, 1));
        oList.add(new PointProd(10, 12));
        oList.add(new IntPoint(21, 112));
        oList.add(new PointSum(17, 90));

        Object[] oResult = Java8StreamMapCollect.getTheseObjects(oList, new PointSum(9, 99), 5);
        assertEquals(1, oResult.length);
        assertEquals(new IntPoint(17, 90), oResult[0]);

        assertEquals(7, oList.size());
        assertEquals(new IntPoint(1, 1), oList.get(0));
        assertEquals(new IntPoint(1, 0), oList.get(1));
        assertEquals(new IntPoint(10, 2), oList.get(2));
        assertEquals(new IntPoint(1, 1), oList.get(3));
        assertEquals(new IntPoint(10, 12), oList.get(4));
        assertEquals(new IntPoint(21, 112), oList.get(5));
        assertEquals(new IntPoint(17, 90), oList.get(6));
    }
}