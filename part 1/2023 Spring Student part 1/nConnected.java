import java.lang.*;
import java.util.*;
/**
 * @author  Don Allen
 * @version 2021 Wittry Contest
 */
public class nConnected
{
    /*
     *   str != null
     *   
     */
    public static int getNConnected(String str)
    {
        int max = 1;
        String current = str.substring(0,1);
        int count = 1;

        for (int i = 1; i < str.length(); i++){
            if (!current.equals(str.substring(i,i+1))){
                if (max < count) max = count;
                count = 1;
                current = str.substring(i,i+1);
            }
            else {
                count++;
            }
        }
        if (max < count) max = count;
        return max;
    }

    /*
     *   str != null
     *   k > 0
     */
    public static String rotateKitems(String str, int k)
    {
        ArrayList<String> all = new ArrayList<String>();

        all.add(str);
        String temp = str.substring(k,str.length())+str.substring(0,k);
        while (!temp.equals(str)){
            all.add(temp);
            temp = temp.substring(k,temp.length())+temp.substring(0,k);
        }
        
        int[] allVals = new int[all.size()];
        int max = 0;
        String maxString = all.get(0);
        for (int i = 0; i < allVals.length; i++){
            allVals[i] = getNConnected(all.get(i));
            if (allVals[i] > max){
                max = allVals[i];
                maxString = all.get(i);
            }
            if (allVals[i] == max){
                if (maxString.compareTo(all.get(i)) > 0) maxString = all.get(i);
            }
        }
        
        return maxString;
    }

}