import java.util.*;
import java.lang.Math;
import java.util.Arrays;
/**
 * The test class FunctionsGoneWild2020.
 *
 * @author  Don Allen
 * @version 2023 Wittry Programming contest
 */
public class FunctionsGoneWild2023
{
    /*
     *   n > 1
     */
    public static String f1(int n)
    {
        String num = Integer.toString(n);
        int numLength = num.length();
        if (num.length() % 2 == 0) {
            String front = num.substring(0, numLength / 2);
            String back = num.substring(numLength / 2, numLength);
            int f = Integer.parseInt(front);
            int b = Integer.parseInt(back);
            if (f > b) {return "FRONT";}
            else if (f < b) {return "BACK";}
            return "FRONTBACK";
        } else {
            String front = num.substring(0, numLength / 2 );
            String back = num.substring(numLength / 2 + 1, numLength);
            int f = Integer.parseInt(front);
            int b = Integer.parseInt(back);
            if (f > b) {return "FRONT";}
            else if (f < b) {return "BACK";}
            return "FRONTBACK";
        }
    }

    /*
     *    Given the String "d3739d0" and the number 60,
     *           return the number that replaces d so that d3739d0 is divisible by 60?
     *    div != 0
     *    
     *    str contains:
     *          at least one non zero digit
     *          str.indexOf("-") < 0;
     *          str may contain more than one d
     */   
    public static int f2(String str ,int div)
    {
        String[] strAsArray = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strAsArray[i] = str.substring(i, i+1);
        }
        for (int i = 0; i <= 9; i++) {
            String[] newStr = new String[strAsArray.length];
            for (int z = 0; z < strAsArray.length; z++) {
                newStr[z] = strAsArray[z];
            }

            for (int j = 0; j < newStr.length; j++) {
                if (newStr[j].equals("d")){
                    newStr[j] = Integer.toString(i);
                }
            }
            String num = "";
            for (int k = 0; k < newStr.length; k++) {
                num = num + newStr[k];
            }
            int n = Integer.parseInt(num);
            if (n % div == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int f3(int n)
    {
        if (n >= 200 && n % 2 == 0) {
            return f3( ((n * n + 21) / (5 * (n-5))))  + n/3;
        } else if (n >= 200 && n % 2 == 1) {
            return f3( ((7 * n - 13)/ (3 * n - 12) + n / 5)) + 2;
        } else if (50 < n && n < 200) {
            return f3( (2 * n) % (1 + n / 4) ) + (2 * n + 1) / 3;
        } else {
            return (int) Math.pow((Math.abs(n - 2) ), n % 5);
        }
    }

    public static int f4(int a, int b, int c)
    {
        int sigma = 0;
        for (int i = Math.max(a * b - c, a * c - b); i <= Math.min(2 * a * b + c, 2 * b * c + a); i++) {
            int x = (int) (i * i * (2 * c*c * (a+b) / (a + Math.abs(b - c)) ));
            int y = (int) ( i * (Math.max(b, c) * Math.max(a * b, Math.abs(a - c)) / Math.max( Math.min( a*c, b*c), Math.min(2*b, 3*c)) ));
            sigma = sigma + x + y;
        }
        return sigma;
    }

    public static double f5(String num)
    {
        String phoneNum = cleanPhoneNumber(num);
        double dist = 0;
        for (int i = 0; i < phoneNum.length() - 1; i++) {
            int d1 = Integer.parseInt(phoneNum.substring(i, i+1));
            int d2 = Integer.parseInt(phoneNum.substring(i+1, i+2));
            int d1X = getX(d1);
            int d1Y = getY(d1);
            int d2X = getX(d2);
            int d2Y = getY(d2);
            dist += Math.sqrt( Math.pow(d2X - d1X, 2) + Math.pow(d2Y - d1Y, 2));
        }
        return dist;
    }

    public static int getX(int num) {
        if (num == 0) {return 2;}
        if (num % 3 == 1) {return 1;}
        else if (num % 3 == 2) {return 2;}
        else if (num % 3 == 0) {return 3;}
        return -1;
    }

    public static int getY(int num) {
        if (num == 0) {return 4;}
        if (num <= 3) {return 1;}
        else if (num <= 6) {return 2;}
        else if (num <= 9) {return 3;}
        return -1;
    }

    public static String cleanPhoneNumber(String num) {
        String ans = "";
        for (int i = 0; i < num.length(); i++) {
            String digit = num.substring(i, i+1);
            if (!digit.equals("-")) {
                ans = ans + digit;
            }
        }
        return ans;
    }

    public static double f6(double x, double y, double z)
    {
        if (Math.tan(x) > Math.cos( (z + Math.PI) / (3 * y))) {
            return Math.log( Math.pow(Math.E, 2 * x -y)) / Math.log(10);
        } else {
            return Math.PI * Math.log( Math.pow(y, Math.E + z));
        }
    }

    public static Set<String> hs = new HashSet<>(); 
    public static boolean f7(String s1, String s2) // some help from Ryan Suh
    {
        findSubseq(s1,"");
        return (hs.contains(s2));
    }

    private static void findSubseq(String s, String ans)
    {
        if (s.length()==0) {
            hs.add(ans);
            return;
        }
        findSubseq(s.substring(1), ans + s.charAt(0));
        findSubseq(s.substring(1), ans);
    }

    /*
     *     precondtion:  phrase will only contain:
     *                      Upper case letters
     *                      (Z)ERO, T(W)O, SI(X), FO(U)R, EI(G)HT
     *                      
     *                      (O)NE, T(H)(R)EE, (S)EVEN, (F)IVE
     *                      
     *                      (N)INE
     *                      
     *                   phrase.length() >= 0
     */
    public static String f8(String phrase)
    {
        String[] letters = strToArray(phrase);
        String ans = "";
        while (arrayHas(letters, "Z")) {
            ans += "0";
            letters = removeValue(letters, "Z");
            letters = removeValue(letters, "E");
            letters = removeValue(letters, "R");
            letters = removeValue(letters, "O");
        }
        while (arrayHas(letters, "W")) {
            ans += "2";
            letters = removeValue(letters, "T");
            letters = removeValue(letters, "W");
            letters = removeValue(letters, "O");
        }
        while (arrayHas(letters, "X")) {
            ans += "6";
            letters = removeValue(letters, "S");
            letters = removeValue(letters, "I");
            letters = removeValue(letters, "X");
        }
        while (arrayHas(letters, "U")) {
            ans += "4";
            letters = removeValue(letters, "F");
            letters = removeValue(letters, "O");
            letters = removeValue(letters, "U");
            letters = removeValue(letters, "R");
        }
        while (arrayHas(letters, "G")) {
            ans += "8";
            letters = removeValue(letters, "E");
            letters = removeValue(letters, "I");
            letters = removeValue(letters, "G");
            letters = removeValue(letters, "H");
            letters = removeValue(letters, "T");
        }
        while (arrayHas(letters, "O")) {
            ans += "1";
            letters = removeValue(letters, "O");
            letters = removeValue(letters, "N");
            letters = removeValue(letters, "E");
        }
        while (arrayHas(letters, "H")) {
            ans += "3";
            letters = removeValue(letters, "T");
            letters = removeValue(letters, "H");
            letters = removeValue(letters, "R");
            letters = removeValue(letters, "E");
            letters = removeValue(letters, "E");
        }
        while (arrayHas(letters, "S")) {
            ans += "7";
            letters = removeValue(letters, "S");
            letters = removeValue(letters, "E");
            letters = removeValue(letters, "V");
            letters = removeValue(letters, "E");
            letters = removeValue(letters, "N");
        }
        while (arrayHas(letters, "F")) {
            ans += "5";
            letters = removeValue(letters, "F");
            letters = removeValue(letters, "I");
            letters = removeValue(letters, "V");
            letters = removeValue(letters, "E");
        }
        while (arrayHas(letters, "N")) {
            ans += "9";
            letters = removeValue(letters, "N");
            letters = removeValue(letters, "I");
            letters = removeValue(letters, "N");
            letters = removeValue(letters, "E");
        }
        int[] ans2 = new int[ans.length()];
        for (int i = 0; i < ans.length(); i++) {
            String letter = ans.substring(i, i+1);
            ans2[i] = Integer.parseInt(letter);
        }
        Arrays.sort(ans2);
        String ans3 = "";
        for (int i = 0; i < ans2.length; i++) {
            ans3 += Integer.toString(ans2[i]);
        }
        return ans3;
    }

    public static boolean arrayHas(String[] arr, String value) {
        for (String s : arr) {
            if (value.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static String[] removeValue(String[] arr, String value) {
        boolean found = false;
        String[] ans = new String[arr.length - 1];
        int ind = 0;

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (value.equals(s) && found == false) {
                found = true;
            } else {
                ans[ind] = s;
                ind++;
            }
        }

        return ans;
    }

    public static String[] strToArray(String str) {
        String[] ans = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ans[i] = str.substring(i, i+1);
        }
        return ans;
    }

    public static boolean f9(boolean x, boolean y, boolean z)
    {
        boolean a = x && !y;
        boolean b = !x && y && z;
        return a || b;
    }

    public static boolean f10(boolean j, boolean k, boolean m, boolean n)
    {
        boolean a = !j && !k && !(m && n);
        boolean b = !j && k && (m ^ n);
        boolean c = j && !k && !m && n;
        boolean d = j && k;
        return a || b || c || d;
    }
}