import java.util.*;
import java.lang.Math;
/**
 * Friday the 13.
 *
 * @author  Tai-Yu Chen
 * @version (a version number or a date)
 */
public class ProblemsPage114
{
   public static int problem_8(int n)
   {
      if (n == 1 || n==2){
          return 0;
        } else {
            return problem_8(n/3) + n;
        }
   }

   public static int problem_9_10(int n)
   {
        if(n==1){ return 0;
        }else{
            return problem_9_10(n/2)+(int)Math.pow(n,2);
        }
   }

   public static int problem_11_13(int n)
   {
      if(n==1){return 0;}else{
        return 4*problem_11_13(n/2)+n;
        }
   }
}