import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2016 Wittry programming contest
 */
public class FunWith1DArraysFinalTest extends junit.framework.TestCase
{
   public void testFunWith1DArrays01()
   {
      assertEquals(true, FunWith1DArrays.hasVasco("bookkeeper"));
      assertEquals(true, FunWith1DArrays.hasVasco("zuzim"));
      assertEquals(false, FunWith1DArrays.hasVasco("java"));
      assertEquals(false, FunWith1DArrays.hasVasco("computer"));

      String[] str1 = {"bookkeeper", "zuzim", "java", "computer", "program", "orange"};
      assertEquals(true, FunWith1DArrays.isMorath(str1));

      String[] str2 = {"bookkeeper", "zuzim", "java", "computer", "abba"};
      assertEquals(false, FunWith1DArrays.isMorath(str2));

      int[] num1 = {74, 23, 17, 80};
      assertEquals(true, FunWith1DArrays.has737(num1));

      int[] num2 = {74, 23, 17, 30};
      assertEquals(false, FunWith1DArrays.has737(num2));

      assertEquals(186, FunWith1DArrays.removeD(158556, 5));
      assertEquals(2168, FunWith1DArrays.removeD(201680, 0));
      assertEquals(57, FunWith1DArrays.removeD(100057, 1));
      assertEquals(-123, FunWith1DArrays.removeD(-123, 7));

      int[] num = {1195, 941, 100057, 3186};
      assertEquals(3186, FunWith1DArrays.largestWithOutDigitD(num, 1).get(0).intValue());
      assertEquals(1, FunWith1DArrays.largestWithOutDigitD(num, 1).size());

      int[] nums = {30936, 9334, 30137, 393336};
      assertEquals(true, FunWith1DArrays.largestWithOutDigitD(nums, 3).contains(new Integer(30936)));
      assertEquals(true, FunWith1DArrays.largestWithOutDigitD(nums, 3).contains(new Integer(393336)));
      assertEquals(2, FunWith1DArrays.largestWithOutDigitD(nums, 3).size());

      int[] n1 = {4, 3, 2, 1};
      assertEquals(6, FunWith1DArrays.degreeOfInversion(n1));
      int[] n2 = {1, 2, 3, 4};
      assertEquals(0, FunWith1DArrays.degreeOfInversion(n2));

      String[] st1 = {"d", "c", "i", "c", "g"};
      int[] ans = FunWith1DArrays.arrayRank(st1);
      assertEquals(5, ans.length);
      assertEquals(2, ans[0]);
      assertEquals(0, ans[1]);
      assertEquals(4, ans[2]);
      assertEquals(1, ans[3]);
      assertEquals(3, ans[4]);

      Comparable[] com2 = {new  Double(3.5), new  Double(39.5), new  Double(15.7), new  Double(3.7), 
                               new  Double(16.9), new  Double(5.9), new  Double(5.8) };
      ans = FunWith1DArrays.arrayRank(com2);
      assertEquals(7, ans.length);
      assertEquals(0, ans[0]);
      assertEquals(6, ans[1]);
      assertEquals(4, ans[2]);
      assertEquals(1, ans[3]);
      assertEquals(5, ans[4]);
      assertEquals(3, ans[5]);
      assertEquals(2, ans[6]);
   }

   public void testFunWith1DArraysHasVasco_02()
   {
      assertEquals(true, FunWith1DArrays.hasVasco("keepr"));
      assertEquals(true, FunWith1DArrays.hasVasco("myuim"));
      assertEquals(true, FunWith1DArrays.hasVasco("qwertyuioplkjhgfdsazxcvbnqm"));
      assertEquals(true, FunWith1DArrays.hasVasco("qwertyuioplkjhgfdjsazxcvbnm"));
      assertEquals(true, FunWith1DArrays.hasVasco("qwertvyuioplkjhgfdsazxcvbnm"));
      assertEquals(true, FunWith1DArrays.hasVasco("qmwertyuioplkjhgfdsazxcvbnm"));

      assertEquals(false, FunWith1DArrays.hasVasco("javel"));
      assertEquals(false, FunWith1DArrays.hasVasco("book"));
      assertEquals(false, FunWith1DArrays.hasVasco("ohio"));
      assertEquals(false, FunWith1DArrays.hasVasco("qwertyuioplkjhgfdsazxcvbnm"));
      assertEquals(false, FunWith1DArrays.hasVasco(""));
   }

   public void testFunWith1DArraysIsMorath_03()
   {
      String[] str1 = {"bookkeeper", "zuzim", "java", "computer", "program", "orange", ""};
      assertEquals(false, FunWith1DArrays.isMorath(str1));

      String[] str1a = {""};
      assertEquals(false, FunWith1DArrays.isMorath(str1a));

      String[] str1b = {"book", "zuzim", "java", "program", "eeee"};
      assertEquals(false, FunWith1DArrays.isMorath(str1b));

      String[] str1c = {"abcde", "fghij", "asfa", "qwewt", "abgha", "hbsah"};
      assertEquals(true, FunWith1DArrays.isMorath(str1c));

      String[] str2 = {"bioub", "uzium", "java", "", "abvba"};
      assertEquals(true, FunWith1DArrays.isMorath(str2));

      String[] str2a = {"abcde", "fghij", "asfa", "qwewt", "abgha", "hbsah", "ommni"};
      assertEquals(true, FunWith1DArrays.isMorath(str2a));

      String[] str2b = {"kiock", "ntion", "java", "abvba", ""};
      assertEquals(true, FunWith1DArrays.isMorath(str2b));
   }

   public void testFunWith1DArraysHas737_04()
   {
      int[] num1 = {74, 7023, 137, 70000, 3, 7};
      assertEquals(true, FunWith1DArrays.has737(num1));

      int[] num1a = {4, 2, 1, 70000, 3, 7};
      assertEquals(true, FunWith1DArrays.has737(num1a));

      int[] num1b = {74, 273, 137, 70000, 3, 7, 45, 12, 67, 7000000, 3000000, -7};
      assertEquals(true, FunWith1DArrays.has737(num1b));

      int[] num1c = {4, 2, 17, 70000, 7};
      assertEquals(true, FunWith1DArrays.has737(num1c));

      int[] num1d = {};
      assertEquals(true, FunWith1DArrays.has737(num1d));

      int[] num2 = {23, 17, 30};
      assertEquals(false, FunWith1DArrays.has737(num2));

      int[] num2a = {74, 23, 17, 30, 700000, 3, 456};
      assertEquals(false, FunWith1DArrays.has737(num2a));

      int[] num2b = {47, 23, 137, 30, 89};
      assertEquals(false, FunWith1DArrays.has737(num2b));

      int[] num2c = {74, 23, 17, 30};
      assertEquals(false, FunWith1DArrays.has737(num2c));

      int[] num2d = {-3, 12};
      assertEquals(false, FunWith1DArrays.has737(num2d));

      int[] num2e = {3};
      assertEquals(false, FunWith1DArrays.has737(num2e));
   }

   public void testFunWith1DArraysRemoveD_05()
   {
      assertEquals(12345678, FunWith1DArrays.removeD(123456780, 0));
      assertEquals(23456789, FunWith1DArrays.removeD(123456789, 1));
      assertEquals(13456789, FunWith1DArrays.removeD(123456789, 2));
      assertEquals(12456789, FunWith1DArrays.removeD(123456789, 3));
      assertEquals(12356789, FunWith1DArrays.removeD(123456789, 4));
      assertEquals(12346789, FunWith1DArrays.removeD(123456789, 5));
      assertEquals(12345789, FunWith1DArrays.removeD(123456789, 6));
      assertEquals(12345689, FunWith1DArrays.removeD(123456789, 7));
      assertEquals(12345679, FunWith1DArrays.removeD(123456789, 8));
      assertEquals(12345678, FunWith1DArrays.removeD(123456789, 9));
      assertEquals(0, FunWith1DArrays.removeD(999, 9));
      assertEquals(-10, FunWith1DArrays.removeD(-14044, 4));
   }

   public void testFunWith1DArraysLargestWithOutDigitD_06()
   {
      int[] num = {1195, 941, 100057, 316, 11011, 9113};
      assertEquals(1195, FunWith1DArrays.largestWithOutDigitD(num, 1).get(0).intValue());
      assertEquals(1, FunWith1DArrays.largestWithOutDigitD(num, 1).size());

      int[] num1 = {4904, 8043, 174, 3146, 45411, 96};
      assertEquals(8043, FunWith1DArrays.largestWithOutDigitD(num1, 4).get(0).intValue());
      assertEquals(1, FunWith1DArrays.largestWithOutDigitD(num1, 4).size());

      int[] num2 = {31506, 13506, 135063, 315063, 15063, 135306};
      List<Integer> ans = FunWith1DArrays.largestWithOutDigitD(num2, 3);
      assertEquals(true, ans.contains(new Integer(31506)));
      assertEquals(true, ans.contains(new Integer(13506)));
      assertEquals(true, ans.contains(new Integer(135063)));
      assertEquals(true, ans.contains(new Integer(315063)));
      assertEquals(true, ans.contains(new Integer(15063)));
      assertEquals(true, ans.contains(new Integer(135306)));
      assertEquals(6, ans.size());
   }

   public void testFunWith1DArraysRemoveDAndDegreeOfInversionWithNonPositive_07()
   {
      assertEquals(-10, FunWith1DArrays.removeD(-14044, 4));
      assertEquals(0, FunWith1DArrays.removeD(-77770, 7));
      assertEquals(-23456789, FunWith1DArrays.removeD(-123456789, 1));
      assertEquals(-13456789, FunWith1DArrays.removeD(-123456789, 2));
      assertEquals(-12456789, FunWith1DArrays.removeD(-123456789, 3));
      assertEquals(-12356789, FunWith1DArrays.removeD(-123456789, 4));
      assertEquals(-12346789, FunWith1DArrays.removeD(-123456789, 5));
      assertEquals(-12345789, FunWith1DArrays.removeD(-123456789, 6));
      assertEquals(-12345689, FunWith1DArrays.removeD(-123456789, 7));
      assertEquals(-12345679, FunWith1DArrays.removeD(-123456789, 8));
      assertEquals(-12345678, FunWith1DArrays.removeD(-123456789, 9));

      List<Integer> ans;

      int[] num = {-1191, -941, -1020057, -316, -9151, -110119};
      ans = FunWith1DArrays.largestWithOutDigitD(num, 1);
      assertEquals(2, ans.size());
      assertEquals(true, ans.contains(new Integer(-1191)));
      assertEquals(true, ans.contains(new Integer(-110119)));

      int[] num1 = {-4905, 8043, 174, 3146, -95411, -96};
      assertEquals(8043, FunWith1DArrays.largestWithOutDigitD(num1, 4).get(0).intValue());
      assertEquals(1, FunWith1DArrays.largestWithOutDigitD(num1, 4).size());

      int[] num2 = {31506, -13506, -135063, 315063, 15063, -135306, 135035};
      ans = FunWith1DArrays.largestWithOutDigitD(num2, 3);
      assertEquals(3, ans.size());
      assertEquals(true, ans.contains(new Integer(31506)));
//      assertEquals(true, ans.contains(new Integer(-13506)));
//      assertEquals(true, ans.contains(new Integer(-135063)));
      assertEquals(true, ans.contains(new Integer(315063)));
      assertEquals(true, ans.contains(new Integer(15063)));
//      assertEquals(true, ans.contains(new Integer(-135306)));
   }

   public void testFunWith1DArraysDegreeOfInversion_08()
   {
      int[] n = {8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
      assertEquals(0, FunWith1DArrays.degreeOfInversion(n));

      int[] n1 =  {8, 4, 11, 3, 0, 2, -6, 1, 10, 9};
      assertEquals(6+ 5+ 7+  3 +2+ 2+ 0  +1, FunWith1DArrays.degreeOfInversion(n1));

      int[] n2 = {18, 12, -6, 23, -4, 15, 9,  1, -1, 8};
      assertEquals(8  +6  +0  +6   +0  +4 +3 + 1, FunWith1DArrays.degreeOfInversion(n2));

      int[] n3 = {564, 423, 292, 199, 113, 97, 85, 69, 65, 55, 23, 0, -1, -5};
      assertEquals(13+12+11+10+9+8+7+6+5+4+3+2+1, FunWith1DArrays.degreeOfInversion(n3));
      
      int[] n4 = {-51, -12, 23, 47, 96, 123, 234, 345, 456, 567, 9999};
      assertEquals(0, FunWith1DArrays.degreeOfInversion(n4));
   }

   public void testFunWith1DArrays_ArrayRank_09()
   {
      String[] st1 = {"q", "w", "e", "r", "t", "y"};
      int[] ans = FunWith1DArrays.arrayRank(st1);
      assertEquals(st1.length, ans.length);
      assertEquals(1, ans[0]);
      assertEquals(4, ans[1]);
      assertEquals(0, ans[2]);
      assertEquals(2, ans[3]);
      assertEquals(3, ans[4]);
      assertEquals(5, ans[5]);

      String[] st1a = {"c", "e", "f", "g", "h", "k", "m", "q", "u", "y"};
      ans = FunWith1DArrays.arrayRank(st1a);
      assertEquals(st1a.length, ans.length);
      assertEquals(0, ans[0]);
      assertEquals(1, ans[1]);
      assertEquals(2, ans[2]);
      assertEquals(3, ans[3]);
      assertEquals(4, ans[4]);
      assertEquals(5, ans[5]);
      assertEquals(6, ans[6]);
      assertEquals(7, ans[7]);
      assertEquals(8, ans[8]);
      assertEquals(9, ans[9]);

      Comparable[] com2 = {new  Integer(3), new  Integer(39), new  Integer(157), new  Integer(37), 
                               new  Integer(16), new  Integer(59), new  Integer(58),
                               new  Integer(16), new  Integer(59), new  Integer(58) };
      ans = FunWith1DArrays.arrayRank(com2);
      assertEquals(com2.length, ans.length);
      assertEquals(0, ans[0]);
      assertEquals(4, ans[1]);
      assertEquals(9, ans[2]);
      assertEquals(3, ans[3]);
      assertEquals(1, ans[4]);
      assertEquals(7, ans[5]);
      assertEquals(5, ans[6]);
      assertEquals(2, ans[7]);
      assertEquals(8, ans[8]);
      assertEquals(6, ans[9]);

      Comparable[] com3 = {new  Integer(9993), new  Integer(9539), new  Integer(7557), new  Integer(6937), 
                               new  Integer(1069), new  Integer(59), new  Integer(58) };
      ans = FunWith1DArrays.arrayRank(com3);
      assertEquals(com3.length, ans.length);
      assertEquals(6, ans[0]);
      assertEquals(5, ans[1]);
      assertEquals(4, ans[2]);
      assertEquals(3, ans[3]);
      assertEquals(2, ans[4]);
      assertEquals(1, ans[5]);
      assertEquals(0, ans[6]);

      Comparable[] com4 = {new  Integer(27), new  Integer(33), new  Integer(45557), new  Integer(33937), new  Integer(27),
                               new  Integer(27), new  Integer(59), new  Integer(27), new  Integer(127) };
      ans = FunWith1DArrays.arrayRank(com4);
      assertEquals(com4.length, ans.length);
      assertEquals(0, ans[0]);
      assertEquals(4, ans[1]);
      assertEquals(8, ans[2]);
      assertEquals(7, ans[3]);
      assertEquals(1, ans[4]);
      assertEquals(2, ans[5]);
      assertEquals(5, ans[6]);
      assertEquals(3, ans[7]);
      assertEquals(6, ans[8]);
   }

   public void testFunWith1DArrays_All_10()
   {
      testFunWith1DArrays_ArrayRank_09();
      testFunWith1DArraysDegreeOfInversion_08();
      testFunWith1DArraysRemoveDAndDegreeOfInversionWithNonPositive_07();
      testFunWith1DArraysLargestWithOutDigitD_06();
      testFunWith1DArraysRemoveD_05();
      testFunWith1DArraysHas737_04();
      testFunWith1DArraysIsMorath_03();
      testFunWith1DArraysHasVasco_02();
      testFunWith1DArrays01();
   }
}