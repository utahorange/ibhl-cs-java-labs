import java.util.*;
import java.lang.Math;
/**
 * RunRunRunAroundNumbers.
 *
 */
public class RunRunRunAroundNumbers
{
   public static boolean isRunRoundNumber(int num)
   {
          int count=0;
          int i=0;
          char[]char_list=Integer.toString(num).toCharArray();
          boolean[]b=new boolean[char_list.length];
          Arrays.fill(b,false);
          Set<Integer>w=new HashSet<Integer>();
          for(char e:char_list){
              w.add(Character.getNumericValue(e));
          }
          if(w.size()!=char_list.length){
              return false;
          }
          while(count<char_list.length){
              i+=Character.getNumericValue(char_list[i]);
              i%=char_list.length;
              b[i]=true;
              count++;
          }
          if(i!=0){
              return false;
          }
          for(boolean bool_value:b){
              if(!bool_value){
                  return false;
              }
          }
          return true;
   }

   public static int getNextRunAroundNumber(int seqNum)
   {
      int num=seqNum;
      while(!isRunRoundNumber(num)){
          num++;
      }
      
      return num;
   }
}