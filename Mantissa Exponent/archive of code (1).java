import java.util.*;
/*
 * Author: Tai-Yu Chen
*/

public class MatissaExponentConverter
{
   /*
    *  Convert the parameter val to its m-bit matissa and e-bit exponent
    *  with one space seperating the matissa and the exponent
    *  
    *  return "np" if the conversion is not possible
    * 
    * preconditions:  -???? >  val  > ????
    * 
    *         see the student tester for sample input/output
    *         
    *   if val == 0, return a mantissa = 000...000 and exponent = 000....0
    */
   public static String toMatissaExponent(double val, int m, int e)
   {
        String ans = "";
        if(val==0){ // for case val = 0
            for(int i=0;i<m;i++){
                ans+="0";
            }
            ans+=" ";
            for(int i=0;i<e;i++){
                ans+="0";
            }
        }

        String bin = toFixedPoint(val);
        if(val <0){ // extreme cringe
        }else{
            int i=0;
            for(i =0;i<bin.length();i++){
                if(bin.substring(i,i+1).equals("1")||bin.substring(i,i+1).equals(".")){
                    break; // find either "1" or "." in fixed pt as string
                }
            }
            int j;
            for(j=i;j<bin.length();j++){
                if(bin.substring(j,j+1).equals("1")||bin.substring(j,j+1).equals(".")){
                    
                }
            }
            int n = Math.abs(j-i);
        }
        return ans;
   }
   public static String toFixedPoint(double val){
        int pre_dec = Integer.valueOf((""+val).split(".")[0]);
        int post_dec = Integer.valueOf((""+val).split(".")[1]);
        String pre_bin = toBinary(pre_dec);
        String post_bin = "";
        double post = Double.parseDouble("0."+post_dec);
        int n = 0;
        while(post-Math.floor(post)!=0.0){
            post*=2;
            n++;
        }
        for(int i=0;i<n;i++){post_bin+="0";}
        post_bin += toBinary(post);
        return pre_bin+"."+post_bin;
   }
   public static String toBinary(double val){
        String ans = "";
        while (val >0){
            if(val %2==0){
                ans = "1"+ans;
            }else{
                ans = "0"+ans;
            }
            val/=2;
        }
        return ans;
   }
   /*
    *    converts the mantissa-exponent string to its equivalent real number
    *    
    *    precondition: str contains one space seperating the matissa from the exponent 
    *
    * 
    *         see the student tester for sample input/output
    */
   public static double toDouble(String str)
   {
      double ans=0;
        String m = str.split(" ")[0];
        String e = str.split(" ")[1];
        int e_num =0;
        if(m.substring(0,1).equals("1")){ans-=1;}
        for(int i=1;i<m.length();i++){ // skip first char
            if(m.substring(i,i+1).equals("1")){
                ans+=Math.pow(2,(i*-1));
            }
        }
        if(e.substring(0,1).equals("1")){ans+=Math.pow(2,e.length()-1);}
        for(int i=e.length()-1;i>=1;i--){
            if(e.substring(i,i+1).equals("1")){
                e_num+=Math.pow(2,(e.length()-i-1));
            }
        }
        return (ans*Math.pow(2,e_num));
   }
}