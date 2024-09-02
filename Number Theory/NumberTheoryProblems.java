import java.util.*;
import java.lang.Math;
/**
 * Friday the 13.
 *
 * @author  a combination of the brainpower of taiyu and the w gameplay of aisheek
 * @version (a version number or a date)
 */
public class NumberTheoryProblems
{

    /*
     *    return the largest digit in m
     *    
     *    remmeber % 10 returns the vlaue in the ones place value
     */
    public int get_largestDigit(int m)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        if (m == 0) {
            return 0;
        }
        while (m > 0)
        {
            a.add(m % 10);
            m = m / 10;
        }
        Collections.sort(a);
        return a.get(a.size() - 1);

    }
    /*
     *    returns the prime factorization of m
     */
    public ArrayList<PrimeFactor> getPrimeFactorization(int m)
    {
        ArrayList<PrimeFactor> lpf = new ArrayList<PrimeFactor>();
        ArrayList<Integer> hi = new ArrayList<Integer>();
        int i = 2;
        if (m == 1 || m == 0) {
            lpf.add(new PrimeFactor(m, 0));
            return lpf;
        }
        while (m > 1) {
            while (m % i == 0) {
                hi.add(i);
                m = m / i;
            }
            i++;
        }
        // System.out.println(hi);
        HashSet<Integer> elements = new HashSet<Integer>();
        for (Integer h : hi) {
            elements.add(h);
        }
        // System.out.println(elements);
        int counter = 0;
        for (Integer e : elements) {
            // System.out.println(hi);
            // System.out.println(elements);
            counter = 0;
            for (Integer hii : hi) {
                if (hii.equals(e)) {
                    // System.out.println("it happened");
                    // System.out.println(Integer.valueOf(hii));
                    // System.out.println(Integer.valueOf(e));
                    // System.out.println(Integer.valueOf(hii) == Integer.valueOf(e));
                    counter++;
                }
            }
            lpf.add(new PrimeFactor(e, (int) counter));
        }
        System.out.println(lpf);
        return lpf;
    }

    public int get_GCD(int m, int n)
    {
        int a; int b;
        if (m > n){ a = m; b = n;}
        else a = n; b = m;
        for (int i = b; i > 1; i--)
        {
            if (m % i == 0 && n % i == 0){
                return i;
            }
        }
        return 1;
    }

    public int get_LCM(int m, int n)
    {
        return (int) m / get_GCD(m, n) * n ;
    }

    public String toBinary(int n)
    {
        String ans = "";
        if (n == 0) {
            return "0";
        }
        n++;
        int i = 0;
        while (Math.pow(2, i) < n)
        {
            i++;
        }
        
        while (i > 0)
        {
            i--;
            if (Math.pow(2, i) < n){
                n -= Math.pow(2, i);
                ans = ans + "1";
            }
            else
            {
                ans = ans + "0";
            }
        }
        // for (int j = i; j > 0; j--)
        // {
        //     ans = ans + "0";
        // }
        return ans;
    }

    public String toHexadecimal(int n)
    {
        String ans = "";
        if (n == 0) {
            return "0";
        }
        String[] rah = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        while (n > 0)
        {
            ans = "" + rah[n % 16] + ans;
            n = n / 16;
        }
        return ans;
    }
    public int indexOf(String[] hi, String alsoHi)
    {
        for (int i = 0; i < hi.length; i++)
        {
            if (hi[i].equals(alsoHi)){
                return i;
            }
        }
        return -1;
    }
    public String hexadecimalToBinary(String hex)
    {
        String ans = "";
        if (hex.equals("")) {
            return "";
        }
        String[] rah = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String[] rahPart2 = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        ArrayList<String> hi = new ArrayList<String>();
        for (int i = 0; i < hex.length(); i++)
        {
            hi.add(hex.substring(i, i+1));
        }
        ArrayList<String> hiPart2 = new ArrayList<String>();
        for (int i = 0; i < hi.size(); i++)
        {
            hiPart2.add(rahPart2[indexOf(rah,hi.get(i))]);
        }
        for (int i = 0; i < hiPart2.size(); i++)
        {
            ans = ans + hiPart2.get(i);
        }
        if (ans.equals("0")) {
            return ans;
        }
        while (ans.length() > 1 && ans.substring(0,1).equals("0"))
        {
            ans = ans.substring(1,ans.length());
        }
        return ans;
    }

    public int binaryToDecimal(String bin)
    {
        int ans = 0;
        if (bin.equals("0")) {
            return 0;
        }
        int h = bin.length();
        for (int i = h-1; i >= 0; i--) {
            ans += Integer.parseInt(bin.substring(i, i+1)) * Math.pow(2, h-i-1);
            
        }
        return ans;
    }

    public int hexadecimalToDecimal(String hex)
    {
        return binaryToDecimal(hexadecimalToBinary(hex));
    }

    //   no leading zero's allowed
    public String binaryToHexadecimal(String bin)
    {
        return (toHexadecimal(binaryToDecimal(bin)));
        // String ans = "";
        // while (bin.length() % 4 != 0)
        // {
            // bin = "0" + bin;
        // }
        // ArrayList<String> hi = new ArrayList<String>();
        // for (int i = 0; i <= bin.length() - 4; i += 4)
        // {
            // hi.add(bin.substring(i, i+4));
        // }
        // String[] rah = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        // ArrayList<Integer> dec = new ArrayList<Integer>();
        // for (int i = 0 ; i < hi.size(); i++)
        // {
            // dec.add(binaryToDecimal(hi.get(i)));
        // }
        // ArrayList<String> hex = new ArrayList<String>();
        // for (int i = 0; i < dec.size(); i++)
        // {
            // hex.add(toHexadecimal(dec.get(i)));
        // }
        // for (int i = 0; i < hex.size(); i++)
        // {
            // ans = ans + hex.get(i);
        // }
        // return ans;
    }

    public int page246_algorithm_5_2_19(int base, int exp, int mod)
    {
        int result = 1;
        int a = base;
        int n = exp;
        int z = mod;
        int x = a % z;
        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * x) % z;
            }
            x = (x * x) % z;
            n = (int) (n / 2);
        }
        return result;
    }
}