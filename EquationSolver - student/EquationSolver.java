import java.util.*;
import java.lang.*;
import java.io.*;

/*
 *     Your goal is to build a, b and c so that the equation a * b + c comes as closes to target as possible
 *     
 *     You will build a first, then build b and then build c
 * 
 *     add the number n, 0 <= n <= 9, to any unoccupied place value in the String num.
 *     
 *     e.g., if the str = " 3 ", the build_a(str, 8) could return:    "83 " or " 38"
 *     or    if the str = "  1  5", the build_a(str, 0) could return:
 *                              "0 1 5", " 01 5" or "  105"
 */

public class EquationSolver 
{
    private int target;

    /*
     *   you should keep a record of the values of a and b and c.
     *   
     *   I will let you figure out how you want to accomplish that task
     *    
     */    

    /* post condition 
     *   0 <= t <= 99,999
     */
    public EquationSolver(int t)
    {
        target = t;
    }

    public String getName()
    {
        return "your name goes here";
    }

    /*
     *    create term a of the equation a * b + c that is closes to target
     *    
     *    0 <= a <= 999
     */
    public String build_a(String str, int n)
    {
        return "  " + n;
    }

    /*
     *    create term b of the equation a * b + c that is closes to target
     *    
     *    0 <= b <= 999
     */
    public String build_b(String str, int n)
    {
        return "  " + n;
    }

    /*
     *    create term c of the equation a * b + c that is closes to target
     *    
     *    0 <= c <= 99999
     */
    public String build_c(String str, int n)
    {
        return "    " + n;
    }
}