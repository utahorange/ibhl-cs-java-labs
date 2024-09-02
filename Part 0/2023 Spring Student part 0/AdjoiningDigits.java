import java.lang.*;
import java.util.*;
import java.lang.Math;
/**
 * @author  Ryan Suh
 * @version 2023 Wittry Contest
 */
public class AdjoiningDigits
{
    public static boolean isDivisibleBy(int number, int[] divisors)
    {
        for(int div: divisors){
            if(number%div!=0){
                return false;
            }
        }
        return true;
    }

    public static int getLCM(int[] num)
    {
        boolean a=false;
        int q=1;
        while(true){
            a=false;
            for(int n:num){
                if (!(q%n==0)){
                    a=true;
                }
            }
            if(!a){
                break;
            }
            q++;
        }
        return q;
    }

    /*    
    assertEquals(155232, AdjoiningDigits.adjoinDigits(523, 3, new int[] {7, 8, 9} ));
    assertEquals(1050, AdjoiningDigits.adjoinDigits(50, 2, new int[] {2, 5} ));
     */

    public static int adjoinDigits(int num, int numDigits, int[] divisors) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<(int)(Math.pow(10,numDigits));i++){
            String a=Integer.toString(i);
            String pow;
            while(a.length()<numDigits){
                a="0"+a;
            }
            for(int q=0;q<a.length()+1;q++){
                boolean good=true;
                pow=a.substring(0,q)+Integer.toString(num)+a.substring(q,a.length());
                for(int div:divisors){
                    if(Integer.parseInt(pow)%div!=0){
                        good=false;
                    }
                }
                if((int)(Integer.parseInt(pow)/Math.pow(10,numDigits+Integer.toString(num).length()-1))==0){
                    good=false;
                }

                if(good){
                    ans=Math.min(ans,Integer.parseInt(pow));
                }
            }
        }
        return ans;
    }

}