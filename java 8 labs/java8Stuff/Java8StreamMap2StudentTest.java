import java.util.*;
import kareltherobot.*;
import java.awt.Point;
/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2019 Java 8 mapping
 */
public class Java8StreamMap2StudentTest extends junit.framework.TestCase implements Directions
{
    public void testJava8StreamMap01()
    {
        World.setDelay(0);
        

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