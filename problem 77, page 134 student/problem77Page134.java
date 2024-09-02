import java.util.*;
import java.lang.Math;
/**
 * problem77 Page134  Weird String Function
 *
 * @author Tai-Yu Chen
 * @version (a version number or a date)
 */
public class problem77Page134
{
    // can define instance variables here
    String[] X = new String[3];
/*
 *  domain is an array with three elements
 */
   public problem77Page134(String[] domain) // domain is X
   {
        X[0] = domain[0]; X[1] = domain[1]; X[2] = domain[2];
   }

/*
 *  y is an array of length 3
 *  returns a String according to the description of problem 77-81 on page 134
 */
   public String weirdStringFunction(String[] y)
   {
      String ans = "";
      for(String val:y){
        if(X[0].equals(val)||X[1].equals(val)||X[2].equals(val)){
            ans += "1";
        }else{
            ans+= "0";
        }
        }
      return ans;
   }
}