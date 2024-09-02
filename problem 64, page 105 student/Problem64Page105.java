import java.util.*;
import java.lang.Math;
/**
 * Problem64Page105.
 *
 * @author  Tai-Yu Chen
 * @version (a version number or a date)
 */
public class Problem64Page105
{
/*
 *  1 <= num < ????
 */
   public static int evaluate_J(int num)
   {
      double ans =0;
      int i=2;
      while(i<num){
          i*=2;
        }
        i=i/2;
        int j = num-i;
        return 2*j+1;
   }
}