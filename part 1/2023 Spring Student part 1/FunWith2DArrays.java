import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * The test class StringSimilarity.
 *
 * @author  Don Allen
 * @version 2015 Wittry Contest
 */
public class FunWith2DArrays
{
/*
 *  0 = up
 *  1 = up and right
 *  2 = right
 *  3 = right and down
 *  4 = down
 *  5 = down and left
 *  6 = left;
 *  7 = up and left
 */
   public static int[][] pathWalk(int size, int startRow, int startCol, int[] walk)
   {
      int[][] ans = new int[size][size];
      
      int row = startRow;
      int col = startCol;
      int ind = 0;
      ans[row][col] = 1;
      while (ind < walk.length) {
          if (walk[ind] == 0) {
              row--; 
              row += size;
              row = row % size;
              ans[row][col] = ans[row][col] + 1;
          }
          else if (walk[ind] == 1) {
              row--;
              row += size;
              row = row % size;
              col++;
              col += size;
              col %= size;
              ans[row][col] = ans[row][col] + 1;
          }else if (walk[ind] == 2) {
              col++;
              col += size;
              col %= size;
              ans[row][col] = ans[row][col] + 1;
          }
          else if (walk[ind] == 3) {
              row++;
              row += size;
              row = row % size;
              col++;
              col += size;
              col %= size;
              ans[row][col] = ans[row][col] + 1;
          }
          else if (walk[ind] == 4) {
              row++;
              row += size;
              row = row % size;
              ans[row][col] = ans[row][col] + 1;
          }
          else if (walk[ind] == 5) {
              row++;
              row += size;
              row = row % size;
              col--;
              col += size;
              col %= size;
              ans[row][col] = ans[row][col] + 1;
          }
          else if (walk[ind] == 6) {
              col--;
              col += size;
              col %= size;
              ans[row][col] = ans[row][col] + 1;
          }
          else if (walk[ind] == 7) {
              row--;
              row += size;
              row = row % size;
              col--;
              col += size;
              col %= size;
              ans[row][col] = ans[row][col] + 1;
          }
          ind++;
      }
      return ans;
   }

/*
 *   return true if num has the Gynn property.
 *      A number has the Gynn property if all the digits of num are either 0, 1, 3, 4, 5, 6, 7 or 8
 *   otherwise rerturn false
 */
   public static boolean hasGynnProperty(int num)
   {
      String stringNum = "" + num;
      for (int i = 0; i < stringNum.length(); i++) {
          if (stringNum.substring(i, i+1).equals("2") || stringNum.substring(i,i+1).equals("9")) {
              return false;
          }
      }
      return true;
   }

/*
 *   return true if 2D array num has the Gynn property.
 *   otherwise rerturn false
 */
   public static boolean hasArrayGynnProperty(int[][] num)
   {
      boolean[] row = new boolean[num.length];
      boolean[] col = new boolean[num.length];
      int temp1 = 0; 
      int temp2 = 0;
      for (int r = 0; r < num.length; r++) {
          for (int c = 0; c < num[r].length; c++) {
              if (hasGynnProperty(num[r][c])) {
                  temp1 += 1;
              }
              else {
                  temp2 += 1;
              }
              
          }
          row[r] = temp1 > temp2;
          temp1 = 0; temp2 = 0;
      }
      temp1 = 0; temp2 = 0;
      for (int c = 0; c < num[0].length; c++) {
          for (int r = 0; r < num.length; r++) {
              if (hasGynnProperty(num[r][c])) {
                  temp1 += 1;
              }
              else {
                  temp2 += 1;
              }
              
          }
          col[c] = temp1 > temp2;
          temp1 = 0; temp2 = 0;
      }
      int numRows = 0;
      for (int i = 0; i < row.length; i++) {
          if (row[i]) {
              numRows ++;
          }
      }
      int numCols = 0;
      for (int i = 0; i < col.length; i++) {
          if (col[i]) {
              numCols++;
          }
      }
      return (numCols == num[0].length || numRows == num.length);
   }
    
/*
 *   return true if 2D array num has the Super Gynn property.
 *   otherwise rerturn false
 */
   public static boolean hasArraySuperGynnProperty(int[][] num)
   {
      boolean[] row = new boolean[num.length];
      boolean[] col = new boolean[num.length];
      int temp1 = 0; 
      int temp2 = 0;
      for (int r = 0; r < num.length; r++) {
          for (int c = 0; c < num[r].length; c++) {
              if (hasGynnProperty(num[r][c])) {
                  temp1 += 1;
              }
              else {
                  temp2 += 1;
              }
              
          }
          row[r] = temp1 > temp2;
          temp1 = 0; temp2 = 0;
      }
      temp1 = 0; temp2 = 0;
      for (int c = 0; c < num[0].length; c++) {
          for (int r = 0; r < num.length; r++) {
              if (hasGynnProperty(num[r][c])) {
                  temp1 += 1;
              }
              else {
                  temp2 += 1;
              }
              
          }
          col[c] = temp1 > temp2;
          temp1 = 0; temp2 = 0;
      }
      int numRows = 0;
      for (int i = 0; i < row.length; i++) {
          if (row[i]) {
              numRows ++;
          }
      }
      int numCols = 0;
      for (int i = 0; i < col.length; i++) {
          if (col[i]) {
              numCols++;
          }
      }
      return (numCols == num[0].length && numRows == num.length);
   }
}