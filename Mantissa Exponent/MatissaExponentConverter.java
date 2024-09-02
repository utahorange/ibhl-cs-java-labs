import java.util.*;

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
    * Author: Tai-Yu Chen
    */
   public static String toMatissaExponent(double val, int m, int e)
   {
       String ans=""+val;
       String exp="";
       int expNum=0;
       if(val>0)
       {
           expNum=Integer.toBinaryString(Integer.parseInt(ans.substring(0,ans.indexOf(".")))).length();
               ans=Integer.toBinaryString(Integer.parseInt(ans.substring(0,ans.indexOf("."))))+toDecimalBinary(ans.substring(ans.indexOf(".")+1));
           ans="0"+ans;
           if(ans.length()>m)
               return "np";
           while(ans.length()<m)
               ans="0"+ans;
           exp=Integer.toBinaryString(expNum);
           if(exp.length()>e)
               return "np";
           while(exp.length()<e)
               exp="0"+exp;
       }
       else if(val<0)
       {
           ans=""+Math.abs(val);
           expNum=Integer.toBinaryString(Integer.parseInt(ans.substring(0,ans.indexOf(".")))).length();
           ans=Integer.toBinaryString(Integer.parseInt(ans.substring(0,ans.indexOf("."))))+toDecimalBinary(ans.substring(ans.indexOf(".")+1));
           ans="0"+ans;
           String temp="";
           for(int a=0; a<ans.length(); a++)
           {
               if(ans.substring(a,a+1).equals("1"))
                   temp+="0";
               else
                   temp+="1";
           }
           ans=Integer.toBinaryString((int)toDouble(temp)+1);
           if(ans.length()>m)
               return "np";
           while(ans.length()<m)
               ans="0"+ans;
           exp=Integer.toBinaryString(expNum);
           if(exp.length()>e)
               return "np";
           while(exp.length()<e)
               exp="0"+exp;
       }
       else if(val==0)
       {
           for(int a=0; a<m; a++)
               ans+="0";
           for(int a=0; a<e; a++)
               exp+="0";
       }
       
       return ans + " " + exp;
   }

   /*
    *    converts the mantissa-exponent string to its equivalent real number
    *    
    *    precondition: str contains one space seperating the matissa from the exponent 
    *t
    * 
    *         see the student tester for sample input/output
    */
   public static double toDouble(String str)
   {
       double mantissa=0;
       double exp=0;
       for(int x=0; x<str.indexOf(" "); x++)
       {
           if(str.substring(x,x+1).equals("1") && x==0)
               mantissa-=1;
           else if(str.substring(x,x+1).equals("1"))
               mantissa+=Math.pow(2,-x);
       }
       str=str.substring(str.indexOf(" ")+1);
       for(int x=0; x<str.length(); x++)
       {
           if(str.substring(x,x+1).equals("1") && x==0)
               exp+= -Math.pow(2,str.length()-1);
           else if(str.substring(x,x+1).equals("1"))
               exp+=Math.pow(2,str.length()-1-x);
       }
       return mantissa*Math.pow(2,exp);
   }
   
   
   public static String toDecimalBinary(String num)
   {
       String ans="";
       int temp=Integer.parseInt(num);
       int count=(int)Math.pow(2, -1*num.length());
       Stack<Integer> s=new Stack<Integer>();
       for(int x=count; x>=0; x-=Math.pow(2, -1*x))
       {
           if(temp-Math.pow(2,x*-1)>=0)
           {
               temp-=Math.pow(2,x*-1);
               s.push(1);
           }
           else
               s.push(0);
       }
       while(s.size()>0)
           ans+=s.pop();
       return ans;
   }
   
}
