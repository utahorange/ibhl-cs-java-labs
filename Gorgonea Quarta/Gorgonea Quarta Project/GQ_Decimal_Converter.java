import java.util.*;
/**
 * Write a description of class GorgoneaQuarta here.
 * 
 * @author Tai-Yu Chen
 * 
 * This will convert GQ to decimal and decimal to GQ.
 */
public class GQ_Decimal_Converter
{
    public static int toDecimal(String str)
    {
       int ans=0;
        for(int i=0;i<str.length();i++){
           String c = str.substring(str.length()-i-1,str.length()-i);
           if(c.equals("1")){
               ans += Math.pow(3,i);
            }else if(!c.equals("0")){
                ans += -1*Math.pow(3,i);
            }
        }
        return ans;
    }
    public int closestTo3(int num){
        int ans =0;
        while (ans<num){
            ans+=3;
        }
        return(ans-3);
    }
    public static String change(String i){
        if(i.equals("-")){
            return "0";
        }
        else if(i.equals("0")){
            return "1";
        }
        return "-";
    }
    public static String toGQ(int num)
    {
        boolean isNegative = num<0;
        if(num==0){
            return "0";
        }
        if (num==1){
            return "1";
        }
        if(num==-1){
            return "-";
        }
        num=Math.abs(num);
        ArrayList<String>list=new ArrayList();
        list.add("1");
        list.add("-");
        int c=2;
        
        while(c<num){
            list.set(list.size()-1,change(list.get(list.size()-1)));
            if(list.get(list.size()-1)=="-"){
                int a=list.size()-2;
                boolean w=false;
                while(a>-1&&!w){
                    list.set(a,change(list.get(a)));
                    if(list.get(a)!="-"){
                        w=true;
                    }
                    else{
                        a--;
                    }
                }
                if(a==-1){
                    list.add(0,"1");
                }
            }

            c++;
        }
        String ans="";
        if(isNegative){
            for(String pow:list){
                if(pow.equals("1")){
                    ans+="-";
                }
                else if(pow.equals("-")){
                    ans+="1";
                }
                else{
                    ans+="0";
                }
            }
            return ans;
        }
        for(String pow:list){
            ans+=pow;
        }
        return ans;
    }
}