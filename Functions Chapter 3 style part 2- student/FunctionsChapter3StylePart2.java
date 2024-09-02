/*    implewment (almost) ALL the methods in this class.
 * 
 *    
 *    This project is based on Chapter 3, section 5, Matrices of Relations
 *    
 *    Good luck
 */

import java.util.*;
import java.lang.Math;
/**
 *
 * @author  Tai-Yu Chen
 * @version (a version number or a date)
 */
public class FunctionsChapter3StylePart2
{
/*  add your own instance variables   */
    private int[][] m;
    public FunctionsChapter3StylePart2(int[][] r)
    {
/*   build your own constructor   */
        m = r;
    }

   public int getNumberRows()
   {
      return m.length;
   }

   public int getNumberCols()
   {
      return m[0].length;
   }

/*
 *    replaces the current relation instance variable with r
 *    
 *    YES - this method gets used in the my (stipulator) tester
 */
   public void setRelation(int[][] r)
   {
      m = r;
   }

/*
 *    returns the current relation instance variable 
 */
   public int[][] getRelation()
   {  
      return m;
   }

/*
 *    retruns the number of Order Pairs in the relation
 *      that is, the number of one's (1) in the Matrix
 */
   public int getSize()
   {
        int ans = 0;
        for (int[] i: m) {
            for (int j: i) {
                if (j != 0) {
                    ans++;
                }
            }
        }
        return ans;
   }

    private int rowSize(int row)
    {
        int ans = 0;
        for (int i = 0; i < m[row].length; i++) {
            if (m[row][i] != 0) {
                ans++;
            }
        }
        return ans;
    }
    
    private int colSize(int col)
    {
        int ans = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][col] != 0) {
                ans++;
            }
        }
        return ans;
    }

   
/*
 *    f is a function if
 *       for each x in X, there is exactly one y in Y with (x,y) in f
 *    returns true if the matrix forms a function
 *    returns false otherwise
 */
   public boolean isFunction()
   {
        for (int i = 0; i < m.length; i++) {
            if (rowSize(i) != 1) {
                return false;
            }
        }
        return true;
   }

/* 
 *    A function f from X to Y is said to be one to one if 
 *    for each y in Y, there is at most one x in X with f(x) = y
 *
 *    returns true if the matrix is a function and the function is one to one
 *    returns false otherwise
 */
   public boolean is1To1()   // column sum is one for every column
   {
        for (int i = 0; i < m[0].length; i++) {
            if (colSize(i) > 1)
            {
                return false;
            }
        }
        return isFunction();
   }

/*
 *    A function from X to Y is said to be onto if
 *    the range of f == Y
 *
 *    returns true if the matrix is a function and the function is onto
 *    returns false otherwise
 */
   public boolean isOnTo()    // column sum > 0 for all columns
   {
        for (int i = 0; i < m[0].length; i++) {
            if (colSize(i) == 0)
            {
                return false;
            }
        }
        return isFunction();
   }

/*
 *     returns true if the matrix is a function and the function is bijective
 *              that is both one to one and onto
 *     returns false otherwise
 */
   public boolean isBijective()
   {
      return is1To1() && isOnTo();
   }

/*
 *   precondition:  comp is a function.
 *   
 *   returns a new FunctionsChapter3StylePart2 Object.
 *   The domain of the new Object is this.domain
 *   
 *   The coDomain of the new Object is comp.coDomain
 *   
 *   The new function is the composition: relation o b = b ( relation )
 *   
 *   See the tester for more information
 */
    

   public FunctionsChapter3StylePart2 getComposition(int[][] comp)
   {
        FunctionsChapter3StylePart2 ans = new FunctionsChapter3StylePart2(Matrix.cleanMatrix(Matrix.product(m, comp)));
        return ans;
   }

/*
 *   precondition:  relation is a function.
 *   rel does not have to be both 1-1 and onto
 *   the inverse does not need to be a function
 */
   public int[][] getInverse()
   {
        int[][] ans = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                ans[j][i] = m[i][j];
            }
        }
        return ans;
   }

/*
 * A relation is reflexive if (x, x) in R for every x in X
 * 
 *       returns true if the current relation is reflexive
 *       returns false otherwise
 *       
 *       You should not assume the matrix is a square matrix.
 *       That is, do not assume getNumRows() == getNumCols()
 *       
 *       Or should I say, if getNumRows() != getNumCols(), return false
 */
   public boolean isReflexive()
   {
        if (getNumberRows() != getNumberCols()) {
            return false;
        }
        for (int i = 0; i < getNumberRows(); i++) {
            if (m[i][i] == 0) {
                return false;
            }
        }
        return true;
   }

/*
 *       A relation is symmetric if
 *       for all x, y in X, if (x,y) in R, then (y,x) in R
 * 
 *       returns true if the current relation is symmetric
 *       returns false otherwise
 */
   public boolean isSymmetric()
   {
      return Matrix.matrixEquals(m, getInverse());
   }
/*
 *       A relation is Antisymmetric if
 *       for all x, y in X, if (x,y) in R, and (y,x) in R, then x = y
 * 
 *    returns true if the current relation is Antisymmetric
 *    returns false otherwise
 */
   public boolean isAntiSymmetric()
   {
        int[][] temp = Matrix.squarify(m);
        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp[0].length; j++) {
                if (temp[i][j] == temp[j][i] && temp[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
   }

/*
 *       A relation is transitive:
 *       if (a,b) and (b,c) then (a,c)
 * 
 *       returns true if the current relation is transitive
 *       returns false otherwise
 */
   public boolean isTransitive()
   {
        return Matrix.matrixEquals(Matrix.cleanMatrix(Matrix.product(m, m)), Matrix.squarify(m));
   }

/*
 *    returns true is the relation is an Equivalence Relation
 *    returns false otherwise
 */
   public boolean isEquivalenceRelation()
   {
       return isReflexive() && isSymmetric() && isTransitive();
   }

/* 
 *    returns true is the relation is an Partially Order
 *    returns false otherwise
 */
   public boolean isPartiallyOrder()
   {
      return isReflexive() && isAntiSymmetric() && isTransitive();
   }

/* 
 *     look at the tester
 *
 *    returns [[a, c, ....d], [...], ...[]]
 */
   public String toString()
   {
        if (m.length == 0) {
            return "[[]]";
        }
        StringBuilder ans = new StringBuilder();
        ans.append("[");
        for (int i = 0; i < m.length; i++) {
            ans.append("[");
            for (int j = 0; j < m[i].length; j++) {
                ans.append(m[i][j]);
                ans.append(", ");
            }
            ans = new StringBuilder(ans.substring(0, ans.length() - 2));
            ans.append("], ");
        }
        ans = new StringBuilder(ans.substring(0, ans.length() - 2));
        ans.append("]");
        return ans.toString();
   }
}