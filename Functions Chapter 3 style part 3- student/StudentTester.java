import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
   public void testMatrixHaveSameZeros()
   {
      int[][] a = { {1, 1, 3}, {0, 1, 1}, {5, -2, 1} };
      int[][] b = { {1, 2, 4}, {0, 1, 1}, {5, -2, 1}  };
      int[][] c = { {1, 2, 3}, {0, 1, 1}, {5, -2, -1}  };

      assertEquals(true, MatrixPart2.haveSameNonZeros(a, b));
   }

   public void testStudent()
   {
      int[][] r = { {1, 1, 0}, {0, 0, 1}, {0, 1, 0} };
      int[][] s = { {0, 1, 1, 0}, {1, 1, 0, 1}, {1, 0, 0, 1}, {1, 0, 1, 0} };
      int[][] t = { {0, 1, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 1} };
      int[][] w = { {10, 11, 21, 5, 1}, {21, 20, 4, 13, 14}, {6, 7, 11, 100, 91}, {30, 8, 40, 55, 51}, {90, 91, 210, 9, -1} };

      int[][] rAns = { {1, 1, 0}, {0, 1, 1}, {0, 1, 1} };
      int[][] sAns = { {0, 1, 1, 1}, {1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 0} };
      int[][] tAns = { {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1} };
      int[][] wAns = { {10, 11, 21, 10, 11}, {21, 20, 14, 13, 14}, {11, 12, 11, 100, 91}, {30, 13, 40, 55, 51}, {90, 91, 210, 14, 14} };

      r=FunctionsChapter3StylePart3.makeItReflexive(r);
      assertEquals(true, MatrixPart2.haveSameNonZeros(r, rAns));

      s=FunctionsChapter3StylePart3.makeItSymmetric(s);
      assertEquals(true, MatrixPart2.haveSameNonZeros(s, sAns));

      t=FunctionsChapter3StylePart3.makeItTransitive(t);
      assertEquals(true, MatrixPart2.haveSameNonZeros(t, tAns));

      w=FunctionsChapter3StylePart3.makeItAWarrior(w);
      for (int row = 0; row < w.length; row++)
         for (int col = 0; col < w.length; col++)
            assertEquals(true, w[row][col] == wAns[row][col]);
   }
}