import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * class FunWith1DArrays
 *
 * @author  Aisheek Ghosh, Taiyu Chen, Adriana Zhou
 * @version 2016 Wittry Contest
 */
public class FunWith1DArrays
{
/*
 *   A string has the Vasco property if
 *    1 - The String has a length of 5 or greater.
 *    2 - At least one letter in the String is repeated at least once
 *           (somewhere – the letters do not need to be adjacent).
 */
   public static boolean hasVasco(String str)
   {
       if(str.length()<5){
        return false;}
        for(int x = 0;x<str.length();x++){
            for(int y = 0;y<str.length();y++){
                if(x!=y && str.charAt(x)==str.charAt(y)){
                    return true;
                }
                }
        
        }
      return false;
   }
/*
 *  An array has the Morath property if:
 *   1 -  The array has 5 elements or more;
 *   2 -  No String appears more than once in the array.
 *   3 -  50% or more of Strings in the array have the Vasco property
 */
   public static boolean isMorath(String[] str)
   {
        if(str.length<5){
        return false;}
        int s = 0;
        for(int x = 0;x<str.length;x++){
            for(int y = 0;y<str.length;y++){
                if(x!=y && str[x].equals(str[y])){
                    return false;
                }
                
            }
        if(hasVasco(str[x])){
                    s++;
                }
        }
        return(((double)s)/((double)str.length)>= 0.5);
   }

/*
 *    has737   -  an int array has the 737 property if,
 *                every number which contains a 3 is adjacent to
 *                  (previous AND following) a number that contains 7
 *                That is, if num[ind] contains a 3, and BOTH
 *                    num[ind-1] and num[ind+1] contain a 7,
 *                    then num has the 737 property
 *    The following ints contain a 3:  13, 10003, 59834, -783, 3333, -30
 *    and the following ints contains a 7:  70, -948765, 378, 28974, -7
 *
 *    note     -  if num[ind] contains a 3, and
 *                    if either ind - 1 < 0 or ind + 1 >= num.length,
 *                    then the array does not contains the 737 property
 *    note     -  if no value in num contains a 3,
 *                    then the array num has the 737 property
 *
 *    precondition:  num.length >= 0 (num != null)
 *
 *    note -      if num.length == 0, return true since 
 */
   public static boolean has737(int[] num)
   {
    if(num.length==0) return true;
      if(num.length==1 && !(""+num[0]).contains("3")) return true;
      if(num.length==1 && (""+num[0]).contains("3")) return false;
      
      if(num.length==2){
          if((""+num[0]).contains("3")|| (""+num[1]).contains("3")){
            return false;
            }else{
                return true;
            }
        }
        if (("" + num[0]).contains("3") || ("" + num[num.length-1]).contains("3")) {
            return false;
        }
        for(int i=1;i<num.length-1;i++){
            if((""+num[i]).contains("3") && (!(""+num[i-1]).contains("7") || !(""+num[i+1]).contains("7")) ){
                return false;
            }
        }
        return true;
   }

/*
 *    remove all occurrences of the digit d, 0 <= d < 10 from the int num.
 *    for example:
 *       186 == removeD(158556, 5)
 *       2168 == removeD(201680, 0)
 *     & -123 == removeD(-123, 5)
 */
   public static int removeD(int num, int d)
   {
    List<String> ans = new ArrayList<String>();
    String n = ""+num;
    for(int i =0;i<n.length();i++){
        ans.add(n.substring(i,i+1));
    }
    for(int i = ans.size()-1;i>=0;i--){
        if(ans.get(i).equals(""+d)){
            ans.remove(i);
        }
    }
    String x = "";
    for(int i = 0;i<ans.size();i++){
        x+= ans.get(i);
    }
    if(x.equals(""))return 0;
    return Integer.parseInt(x);
   }

/*
 *    returns a List of all the int(s) in the array num which are the largest
 *            after removing the digit d, 0 <= d < 10 from the int
 *
 *    The order of the numbers in the List is not important
 *    You may not alter the array num
 *    You may use your implementation of the method removedD
 *    You may assume num.length() > 0
 */
   public static List<Integer> largestWithOutDigitD(int[] num, int d)
   {
      ArrayList<Integer> ans = new ArrayList<Integer>();   
      for(int i: num){
        ans.add(removeD(i,d));
    }
    int max = Integer.MIN_VALUE;    
    for(int i: ans){
            max = Math.max(i,max);
        }
        ArrayList<Integer> indexes = new ArrayList<Integer>();
    ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) == max) {
                indexes.add(i);
            }
        }
    
    for(int i: indexes){
        a.add(num[i]);
    }
      return a;
   }

   
   public static int degreeOfInversion(int[] num)
   {
      int sum = 0; 
       for (int i = 0; i < num.length; i++) {
          for (int j = i; j < num.length; j++) {
              if (num[j] < num[i]) {
                  sum++;
              }
          }
      }
      return sum;
   }

/*
 *    The rank of an element in an array of integers is the number of smaller elements in the array plus
 *    the number of equal elements that appear to its left.
 *    
 *    For example, consider the array [4, 3, 9, 3, 7]. The respective ranks of these elements are 2, 0, 4, 1, and 3;
 *    thus the rank array is the array [2, 0, 4, 1, 3].
 */   
   public static int[] arrayRank(Comparable[] items)
   {
      int[] ans = new int[items.length];
      
      for (int i = 0; i < items.length; i++) {
          for (int j = 0; j < items.length; j++) {
              if (j < i) {
                  if (items[i].compareTo(items[j]) >= 0) {
                      ans[i] += 1;
                  }
              }
              else if (j > i) {
                  if (items[i].compareTo(items[j]) > 0) {
                      ans[i] += 1;
                  }
              }
          }
      }
      return ans;
   }
}