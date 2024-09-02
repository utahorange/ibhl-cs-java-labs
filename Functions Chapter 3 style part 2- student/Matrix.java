
/**
 * Write a description of class Matrix here.
 * 
 * need Matrix operations
 * 
 * @author Don Allen
 * @version March 2011
 */
public class Matrix
{
    // All methods will be static methods
    /**
     *    Matrix multiplication
     * 
     * @return     matrix x times matrix y 
     */
    public static int[][] product(int[][] x, int[][] y)
    {
        int[][] a = new int[x.length][y[0].length];   // this is the correct dimension
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                int val = 0;
                for (int k = 0; k < x[0].length; k++) {
                    val += x[i][k] * y[k][j];
                }
                a[i][j] = val;
            }
        }
        return a;
    }

/* 
 *    Set teh diagonal of the Matrix to k
 *    You may assume m.length == m[h].length, 0 <= h < m.length
 */
   public static int[][] setDiagonal(int[][] m, int k)
   {
        int[][] a = m;   // this is the correct dimension
        for (int i = 0; i < a.length; i++) {
            if (i >= m[0].length) {
                break;
            }
            a[i][i] = k;
        }
        return a;
      
   }
   
    public static int[][] cleanMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }
     
    public static boolean matrixEquals (int[][] matrix1, int[][] matrix2)
    {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int[][] squarify(int[][] matrix)
    {
        while (matrix.length < matrix[0].length)
        {
            matrix = addRow(matrix);
        }
        while (matrix.length > matrix[0].length)
        {
            matrix = addCol(matrix);
        }
        return matrix;
    }
    public static int[][] addRow(int[][] matrix)
    {
        int[][] a = new int[matrix.length + 1][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                a[i][j] = matrix[i][j];
            }
        }
        return a;
    }
    public static int[][] addCol(int[][] matrix)
    {
        int[][] a = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                a[i][j] = matrix[i][j];
            }
        }
        return a;
    }
}