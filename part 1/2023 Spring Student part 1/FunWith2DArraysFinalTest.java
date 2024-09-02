import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  Don Allen
 * @version 2016 Wittry programming contest
 */
public class FunWith2DArraysFinalTest extends junit.framework.TestCase
{
   public void testFunWith2DArrays01()
   {
      FunWith2DArrays f2d = new FunWith2DArrays();
      int[] walk = { 3, 6, 5, 2, 1, 0, 7, 4, 3};
      int[][] ans = FunWith2DArrays.pathWalk(4, 2, 1, walk);
      assertEquals(1, ans[0][0]);
      assertEquals(1, ans[0][1]);
      assertEquals(0, ans[0][2]);
      assertEquals(0, ans[0][3]);

      assertEquals(0, ans[1][0]);
      assertEquals(1, ans[1][1]);
      assertEquals(0, ans[1][2]);
      assertEquals(0, ans[1][3]);

      assertEquals(0, ans[2][0]);
      assertEquals(2, ans[2][1]);
      assertEquals(1, ans[2][2]);
      assertEquals(0, ans[2][3]);

      assertEquals(0, ans[3][0]);
      assertEquals(1, ans[3][1]);
      assertEquals(3, ans[3][2]);
      assertEquals(0, ans[3][3]);

      assertEquals(true, FunWith2DArrays.hasGynnProperty(41587));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(2587));
      int[][] gynnNumbers1 = { {3, 6, 5, 2}, {1, 0, 7, 49}, {23, 66, 10, 88}, {48, 53, 200, 308} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(gynnNumbers1));
      int[][] gynnNumbers2 = { {39, 6, 5, 8}, {1, 0, 72, 49}, {93, 66, 1, 88}, {428, 53, 0, 308} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(gynnNumbers2));
      int[][] superGynnNumbers1 = { {3, 659, 5, 17}, {1, 0, 7, 49}, {23, 66, 10, 88}, {48, 53, 200, 308} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(superGynnNumbers1));
      int[][] superGynnNumbers2 = { {3, 659, 5, 127}, {1, 0, 7, 49}, {23, 66, 10, 88}, {48, 53, 200, 308} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(superGynnNumbers2));
    }

   public void testFunWith2DArraysPathWalkWithNoWrapAround02()
   {
      FunWith2DArrays f2d = new FunWith2DArrays();
      int[] walk = {0, 1, 3, 4, 5, 6, 5, 2, 0, 6, 7, 0, 2, 2, 2, 0, 6, 4 };
      int[][] ans = FunWith2DArrays.pathWalk(5, 2, 2, walk);
      assertEquals(0, ans[0][0]);
      assertEquals(0, ans[0][1]);
      assertEquals(1, ans[0][2]);
      assertEquals(2, ans[0][3]);
      assertEquals(0, ans[0][4]);

      assertEquals(1, ans[1][0]);
      assertEquals(1, ans[1][1]);
      assertEquals(3, ans[1][2]);
      assertEquals(1, ans[1][3]);
      assertEquals(1, ans[1][4]);

      assertEquals(1, ans[2][0]);
      assertEquals(0, ans[2][1]);
      assertEquals(1, ans[2][2]);
      assertEquals(0, ans[2][3]);
      assertEquals(1, ans[2][4]);

      assertEquals(0, ans[3][0]);
      assertEquals(1, ans[3][1]);
      assertEquals(2, ans[3][2]);
      assertEquals(1, ans[3][3]);
      assertEquals(0, ans[3][4]);

      assertEquals(0, ans[4][0]);
      assertEquals(1, ans[4][1]);
      assertEquals(1, ans[4][2]);
      assertEquals(0, ans[4][3]);
      assertEquals(0, ans[4][4]);
   }

   public void testFunWith2DArraysPathWalkWithWrapAround03()
   {
      FunWith2DArrays f2d = new FunWith2DArrays();
      int[] walk = { 3, 5, 6, 5, 0, 2, 7, 1, 7, 2, 0, 6, 4, 7, 4, 5, 3, 6, 1, 7, 2, 2, 4, 3, 4};
      int[][] ans = FunWith2DArrays.pathWalk(6, 2, 3, walk);
      assertEquals(1, ans[0][0]);
      assertEquals(1, ans[0][1]);
      assertEquals(1, ans[0][2]);
      assertEquals(0, ans[0][3]);
      assertEquals(0, ans[0][4]);
      assertEquals(0, ans[0][5]);

      assertEquals(2, ans[1][0]);
      assertEquals(3, ans[1][1]);
      assertEquals(1, ans[1][2]);
      assertEquals(0, ans[1][3]);
      assertEquals(0, ans[1][4]);
      assertEquals(1, ans[1][5]);

      assertEquals(1, ans[2][0]);
      assertEquals(1, ans[2][1]);
      assertEquals(1, ans[2][2]);
      assertEquals(1, ans[2][3]);
      assertEquals(0, ans[2][4]);
      assertEquals(1, ans[2][5]);

      assertEquals(1, ans[3][0]);
      assertEquals(1, ans[3][1]);
      assertEquals(1, ans[3][2]);
      assertEquals(0, ans[3][3]);
      assertEquals(1, ans[3][4]);
      assertEquals(1, ans[3][5]);

      assertEquals(0, ans[4][0]);
      assertEquals(1, ans[4][1]);
      assertEquals(3, ans[4][2]);
      assertEquals(1, ans[4][3]);
      assertEquals(0, ans[4][4]);
      assertEquals(0, ans[4][5]);

      assertEquals(0, ans[5][0]);
      assertEquals(1, ans[5][1]);
      assertEquals(0, ans[5][2]);
      assertEquals(0, ans[5][3]);
      assertEquals(0, ans[5][4]);
      assertEquals(0, ans[5][5]);

      f2d = new FunWith2DArrays();
      int[] walk1 = { 1, 3, 0, 4, 7, 5};
      int[][] ans1 = FunWith2DArrays.pathWalk(5, 0, 2, walk1);
      assertEquals(0, ans1[0][0]);
      assertEquals(0, ans1[0][1]);
      assertEquals(2, ans1[0][2]);
      assertEquals(0, ans1[0][3]);
      assertEquals(2, ans1[0][4]);

      assertEquals(0, ans1[1][0]);
      assertEquals(0, ans1[1][1]);
      assertEquals(0, ans1[1][2]);
      assertEquals(0, ans1[1][3]);
      assertEquals(0, ans1[1][4]);

      assertEquals(0, ans1[2][0]);
      assertEquals(0, ans1[2][1]);
      assertEquals(0, ans1[2][2]);
      assertEquals(0, ans1[2][3]);
      assertEquals(0, ans1[2][4]);

      assertEquals(0, ans1[3][0]);
      assertEquals(0, ans1[3][1]);
      assertEquals(0, ans1[3][2]);
      assertEquals(0, ans1[3][3]);
      assertEquals(0, ans1[3][4]);

      assertEquals(0, ans1[4][0]);
      assertEquals(0, ans1[4][1]);
      assertEquals(0, ans1[4][2]);
      assertEquals(2, ans1[4][3]);
      assertEquals(1, ans1[4][4]);
   }

   public void testFunWith2DArraysPathWalkWithCornerWrapAround04()
   {
      FunWith2DArrays f2d = new FunWith2DArrays();
      int[] walk = { 6, 7, 5, 2, 1, 0, 6, 4, 3, 0, 5, 3};
      int[][] ans = FunWith2DArrays.pathWalk(6, 0, 1, walk);
      assertEquals(2, ans[0][0]);
      assertEquals(1, ans[0][1]);
      assertEquals(0, ans[0][2]);
      assertEquals(0, ans[0][3]);
      assertEquals(1, ans[0][4]);
      assertEquals(2, ans[0][5]);

      assertEquals(1, ans[1][0]);
      assertEquals(0, ans[1][1]);
      assertEquals(0, ans[1][2]);
      assertEquals(0, ans[1][3]);
      assertEquals(0, ans[1][4]);
      assertEquals(0, ans[1][5]);

      assertEquals(0, ans[2][0]);
      assertEquals(0, ans[2][1]);
      assertEquals(0, ans[2][2]);
      assertEquals(0, ans[2][3]);
      assertEquals(0, ans[2][4]);
      assertEquals(0, ans[2][5]);

      assertEquals(0, ans[3][0]);
      assertEquals(0, ans[3][1]);
      assertEquals(0, ans[3][2]);
      assertEquals(0, ans[3][3]);
      assertEquals(0, ans[3][4]);
      assertEquals(0, ans[3][5]);

      assertEquals(1, ans[4][0]);
      assertEquals(0, ans[4][1]);
      assertEquals(0, ans[4][2]);
      assertEquals(0, ans[4][3]);
      assertEquals(0, ans[4][4]);
      assertEquals(1, ans[4][5]);

      assertEquals(2, ans[5][0]);
      assertEquals(0, ans[5][1]);
      assertEquals(0, ans[5][2]);
      assertEquals(0, ans[5][3]);
      assertEquals(0, ans[5][4]);
      assertEquals(2, ans[5][5]);
   }

   public void testFunWith2DArraysHasGynnPropertyPositiveNumbersOnly05()
   {
      assertEquals(true, FunWith2DArrays.hasGynnProperty(0));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(111111));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(33333));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(4444));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(5555));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(777));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(8888));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(10000));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(345780));

      assertEquals(false, FunWith2DArrays.hasGynnProperty(111119));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(23333));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(4442555));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(666977));
   }

   public void testFunWith2DArraysHasGynnPropertyBothPosAndNegNumbers06()
   {
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-111111));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-33333));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-4444));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-5555));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-777));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-8888));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-10000));
      assertEquals(true, FunWith2DArrays.hasGynnProperty(-345780));

      assertEquals(false, FunWith2DArrays.hasGynnProperty(111119));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(-23333));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(4442555));
      assertEquals(false, FunWith2DArrays.hasGynnProperty(-666977));
   }

   public void testFunWith2DArraysHasArrayGynnPropertyPositiveNumbersOnly07()
   {
      int[][] num = { { 1,  8, 29, 12, 39},
                      { 1,  3,  4,  5,  6},
                      {70, 16, 34, 85,  0},
                      {12, 30, 17,  6,  5},
                      {12, 19, 29, 20, 90} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num));

      int[][] num1 = { { 1,  8, 29, 12,  3},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num1));

      int[][] num2 = { { 1,  8, 29, 12, 93},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(num2));

      int[][] num3 = { { 1,  8, 29, 12,  3},
                       {91,  3,  4,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num3));

      int[][] num4 = { { 1,  8, 29, 12,  3},
                       {91,  3, 29,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(num4));
   }

   public void testFunWith2DArraysHasArrayGynnPropertyPosAndNegNumbers08()
   {
      int[][] num = { { -1,   8, -29, -12,  39},
                      {  1,   3,   4,  -5,  -6},
                      {-70, -16, -34, -85,   0},
                      {-12,  30,  17,   6,  -5},
                      {-12, -19, -29, -20, -90} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num));

      int[][] num1 = { {  1,   8, -29, -12,   3},
                       { -1,  -3,   4,   5, -26},
                       {-70,  16, -34,  85,  20},
                       { 12,  30,  17,  -6,  -5},
                       {  1,  -1,  -5,  30,   0} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num1));

      int[][] num2 = { { 1,  8, 29, 12, 93},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(num2));

      int[][] num3 = { { -1,   8,  29,  12,  -3},
                       { 91,  -3,   4,   5,  26},
                       { 70,  12, -34, -85,  20},
                       {-18, -30,  27,  96,  -5},
                       { 21,  91,  -5, -30,   0} };
      assertEquals(true, FunWith2DArrays.hasArrayGynnProperty(num3));

      int[][] num4 = { { 1,  8, 29, 12,  3},
                       {91,  3, 29,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArrayGynnProperty(num4));
   }

   public void testFunWith2DArraysHasArraySuperGynnPropertyPositiveNumbersOnly09()
   {
      int[][] num = { { 1,  8, 29, 12, 39},
                      { 1,  3,  4,  5,  6},
                      {70, 16, 34, 85,  0},
                      {12, 30, 17,  6,  5},
                      {12, 19, 29, 20, 90} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num));

      int[][] num1 = { { 1,  8, 29, 12,  3},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(num1));

      int[][] num2 = { { 1,  8, 29, 12, 93},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num2));

      int[][] num3 = { { 1,  8, 29, 12,  3},
                       {91,  3,  4,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(num3));

      int[][] num4 = { { 1,  8, 29, 12,  3},
                       {91,  3, 29,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num4));
    }

   public void testFunWith2DArraysHasArraySuperGynnPropertyBothPosAndNegNumbers10()
   {
      int[][] num = { { -1,   8, -29, -12,  39},
                      {  1,   3,   4,  -5,  -6},
                      {-70, -16, -34, -85,   0},
                      {-12,  30,  17,   6,  -5},
                      {-12, -19, -29, -20, -90} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num));

      int[][] num1 = { {  1,   8, -29, -12,   3},
                       { -1,  -3,   4,   5, -26},
                       {-70,  16, -34,  85,  20},
                       { 12,  30,  17,  -6,  -5},
                       {  1,  -1,  -5,  30,   0} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(num1));

      int[][] num2 = { { 1,  8, 29, 12, 93},
                       { 1,  3,  4,  5, 26},
                       {70, 16, 34, 85, 20},
                       {12, 30, 17,  6,  5},
                       { 1,  1,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num2));

      int[][] num3 = { { -1,   8,  29,  12,  -3},
                       { 91,  -3,   4,   5,  26},
                       { 70,  12, -34, -85,  20},
                       {-18, -30,  27,  96,  -5},
                       { 21,  91,  -5, -30,   0} };
      assertEquals(true, FunWith2DArrays.hasArraySuperGynnProperty(num3));

      int[][] num4 = { { 1,  8, 29, 12,  3},
                       {91,  3, 29,  5, 26},
                       {70, 12, 34, 85, 20},
                       {18, 30, 27, 96,  5},
                       {21, 91,  5, 30,  0} };
      assertEquals(false, FunWith2DArrays.hasArraySuperGynnProperty(num4));
    }
}