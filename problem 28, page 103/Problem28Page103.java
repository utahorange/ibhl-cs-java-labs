import java.util.*;
import java.lang.Math;
/**
 * RunRunRunAroundNumbers.
 *
 * @author  
 * @version (a version number or a date)
 */
public class Problem28Page103
{
/*
 *  1 <= num < ????
 */
   public static double evaluate(int num)
   {
      double ans =0;
      for(int i=1;i<=num;i++){
        ans+=(1.0/(i*(i+1)));
        }
      return ans;
   }
}