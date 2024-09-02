import java.util.*;
/**
 * Bongard
 *
 * @author  Adriana Zhou, Taiyu Chen, Aisheek Ghosh
 * @version 2023 Wittry
 */
public class Bongard
{

    static String tallLetters = "BDFHKLT";
    static String vowels = "AEIOU";
    String[] LW;
    String[] RW;
    int[] propsL;
    int[] propsR;

    public Bongard(String[] leftWords, String[] rightWords)
    {
        LW = leftWords;
        RW = rightWords;
    }

    /*
     *    Tall letters are: BDFHKLT
     */
    public static int getNumTallLetters(String word)
    {
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            if (tallLetters.contains(word.substring(i,i+1))){
                count++;
            }
        }
        return count;
    }

    /*
     *    This methods does not believe that Y is a vowel
     */
    public static int getNumVowels(String word)
    {
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            if (vowels.contains(word.substring(i,i+1))){
                count++;
            }
        }
        return count;
    }

    /*
     *    This methods BELIEVES Y is a vowel
     */
    public static int getNumVowelsWithY(String word)
    {
        String vowelsY = vowels + "Y";
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            if (vowelsY.contains(word.substring(i,i+1))){
                count++;
            }
        }
        return count;
    }

    /*
     *    This returns the last three letters. If word.length() < 3, return word
     */
    public static String endsWith(String word)
    {
        if (word.length() < 3) return word;
        return (word.substring(word.length()-3));
    }

    /*
     *    This returns the first three letters. If word.length() < 3, return word
     */
    public static String startsWith(String word)
    {
        if (word.length() < 3) return word;
        return (word.substring(0,3));
    }

    /*
     *    Compares number of vowels versus the consonants.
     *    
     *       negative num indicates num more consonants thans vowels
     *    
     *       positive num indicates num fewer consonants than vowels
     *       
     *       zero indicates same number of vowels as consonants
     */
    public static int getPlusMinus(String word)
    {
        return 2*getNumVowels(word) - word.length();
    }

    /*
     *    
     */
    public static int getLength(String word)
    {
        return word.length();
    }

    /*
     *    all words will be in ALL CAPS
     *    
     *    returns "LEFT"
     *        if word belongs to leftbox
     *        
     *    returns "RIGHT"
     *        if word belongs to rightbox
     *        
     *    returns "NEITHER"
     *        if word does not belong to either box
     */
    public String whichBox(String word)
    {
        propsL = getProps(LW);
        propsR = getProps(RW);

        String[] props2L = getProps2(LW);
        String[] props2R = getProps2(RW);

        int ta = getNumTallLetters(word);
        int v = getNumVowels(word);
        int vy = getNumVowelsWithY(word);
        int pm = getPlusMinus(word);
        int len = getLength(word);

        String e = endsWith(word);
        String s = startsWith(word);

        int[] propsW = {ta,v,vy,pm,len};
        /*System.out.print("word: (");
        for (int i : propsW) System.out.print(i+",");
        System.out.println(")");

        System.out.print("L: (");
        for (int i : propsL) System.out.print(i+",");
        System.out.println(")");

        System.out.print("R: (");
        for (int i : propsR) System.out.print(i+",");
        System.out.println(")");*/

        Boolean test = true;
        for (int i = 0; i < 5; i++){
            if (propsL[i] != -100) test = (test && (propsL[i]==propsW[i]));
        }
        if (props2L[0] != ""){
            test = (test && e.equals(props2L[0]));
        }
        if (props2L[1] != ""){
            test = (test && s.equals(props2L[1]));
        }
        if (test) return "LEFT";

        test = true;
        for (int i = 0; i < 5; i++){
            if (propsR[i] != -100) test = (test && (propsR[i]==propsW[i]));
        }
        if (props2R[0] != ""){
            test = (test && e.equals(props2R[0]));
        }
        if (props2R[1] != ""){
            test = (test && s.equals(props2R[1]));
        }
        if (test) return "RIGHT";
        return "NEITHER";
    }

    public int[] getProps(String[] arr){
        //(Tall, numVowels, numVowelsY, PlusMinus, len)
        int[] props = new int[5];
        Boolean[] propsB = {true,true,true,true,true};

        props[0] = getNumTallLetters(arr[0]);
        props[1] = getNumVowels(arr[0]);
        props[2] = getNumVowelsWithY(arr[0]);
        props[3] = getPlusMinus(arr[0]);
        props[4] = getLength(arr[0]);

        System.out.print("props: (");
        for (int i : props) System.out.print(i+",");
        System.out.println(")");

        for (String x : arr){
            if (propsB[0]){
                if (getNumTallLetters(x) != (props[0])) propsB[0] = false;
            }
            if (propsB[1]){
                if (getNumVowels(x) != (props[1])) propsB[1] = false;
            }
            if (propsB[2]){
                if (getNumVowelsWithY(x) != (props[2])) propsB[2] = false;
            }
            if (propsB[3]){
                if (getPlusMinus(x) != (props[3])) propsB[3] = false;
            }
            if (propsB[4]){
                if (getLength(x) != (props[4])) propsB[4] = false;
            }
        }

        for (int i = 0; i < 5; i++){
            if (!propsB[i]) props[i] = -100;
        }
        return props;
    }

    public String[] getProps2(String[] arr){
        //(Tall, numVowels, numVowelsY, PlusMinus, len)
        String[] props = new String[2];
        Boolean[] propsB = {true,true};

        props[0] = endsWith(arr[0]);
        props[1] = startsWith(arr[0]);

        /*
        System.out.print("props: (");
        for (String i : props) System.out.print(i+",");
        System.out.println(")");*/

        for (String x : arr){
            if (propsB[0]){
                if (!endsWith(x).equals(props[0])) propsB[0] = false;
            }
            if (propsB[1]){
                if (!startsWith(x).equals(props[1])) propsB[1] = false;
            }
        }

        for (int i = 0; i < 2; i++){
            if (!propsB[i]) props[i] = "";
        }
        return props;
    }
}