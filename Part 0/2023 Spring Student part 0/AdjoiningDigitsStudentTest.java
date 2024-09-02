import java.util.*;

/**
 * The test class
 *
 * @author  Don Allen
 * @version 2023 Wittry programming contest
 */
public class AdjoiningDigitsStudentTest extends junit.framework.TestCase
{
   public void testAdjoiningDigits01()
   {
       assertEquals(true, AdjoiningDigits.isDivisibleBy(100, new int[] {2, 5, 50}));
       assertEquals(false, AdjoiningDigits.isDivisibleBy(100, new int[] {2, 5, 2*3*5}));

       assertEquals(50, AdjoiningDigits.getLCM(new int[] {2, 5, 50}));
       assertEquals(2*3*5, AdjoiningDigits.getLCM(new int[] {2, 5, 15, 2*3*5}));
       assertEquals(3*5*7, AdjoiningDigits.getLCM(new int[] {3, 5, 7}));

       assertEquals(377, AdjoiningDigits.adjoinDigits(77, 1, new int[] {13, 29} ));
       assertEquals(3289, AdjoiningDigits.adjoinDigits(32, 2, new int[] {11, 13, 23} ));
       assertEquals(155232, AdjoiningDigits.adjoinDigits(523, 3, new int[] {7, 8, 9} ));
       assertEquals(1050, AdjoiningDigits.adjoinDigits(50, 2, new int[] {2, 5} ));
   }
}