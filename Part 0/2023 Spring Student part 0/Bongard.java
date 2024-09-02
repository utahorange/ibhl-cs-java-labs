import java.util.*;
/**
 * Bongard
 *
 * @author  Mr. Allen
 * @version 2023 Wittry
 */
public class Bongard
{
    private String[]left;
    private String[]right;
    public Bongard(String[] leftWords, String[] rightWords)
    {
        left=leftWords;
        right=rightWords;
    }

    /*
     *    Tall letters are: BDFHKLT
     */
    public static int getNumTallLetters(String word)
    {
        String a="BDFHKLT";
        int c=0;
        for(int i=0;i<word.length();i++){
            if(a.indexOf(word.charAt(i))>=0){
                c++;
            }
        }
        return c;
    }

    /*
     *    This methods does not believe that Y is a vowel
     */
    public static int getNumVowels(String word)
    {
        String a="AEIOU";
        int c=0;
        for(int i=0;i<word.length();i++){
            if(a.indexOf(word.charAt(i))>=0){
                c++;
            }
        }
        return c;
    }

    /*
     *    This methods BELIEVES Y is a vowel
     */
    public static int getNumVowelsWithY(String word)
    {
        String a="AEIOUY";
        int c=0;
        for(int i=0;i<word.length();i++){
            if(a.indexOf(word.charAt(i))>=0){
                c++;
            }
        }
        return c;
    }

    /*
     *    This returns the last three letters. If word.length() < 3, return word
     */
    public static String endsWith(String word)
    {
        if(word.length()<3){
            return word;
        }
        return word.substring(word.length()-3);
    }

    /*
     *    This returns the first three letters. If word.length() < 3, return word
     */
    public static String startsWith(String word)
    {
        if(word.length()<3){
            return word;
        }
        return word.substring(0,3);
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
        return 2*getNumVowels(word)-word.length();
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
        boolean[]a=new boolean[]{true,true,true,true,true,true,true};
        for(int i=0;i<left.length-1;i++){
            if(getNumTallLetters(left[i])!=getNumTallLetters(left[i+1])){
                a[0]=false;
            }
            if(getNumVowels(left[i])!=getNumVowels(left[i+1])){
                a[1]=false;
            }
            if(getNumVowelsWithY(left[i])!=getNumVowelsWithY(left[i+1])){
                a[2]=false;
            }
            if(!endsWith(left[i]).equals(endsWith(left[i+1]))){
                a[3]=false;
            }
            if(!startsWith(left[i]).equals(startsWith(left[i+1]))){
                a[4]=false;
            }
            if(getPlusMinus(left[i])!=getPlusMinus(left[i+1])){
                a[5]=false;
            }
            if(getLength(left[i])!=getLength(left[i+1])){
                a[6]=false;
            }
        }
        boolean[]b=new boolean[]{true,true,true,true,true,true,true};
        for(int i=0;i<right.length-1;i++){
            if(getNumTallLetters(right[i])!=getNumTallLetters(right[i+1])){
                b[0]=false;
            }
            if(getNumVowels(right[i])!=getNumVowels(right[i+1])){
                b[1]=false;
            }
            if(getNumVowelsWithY(right[i])!=getNumVowelsWithY(right[i+1])){
                b[2]=false;
            }
            if(!endsWith(right[i]).equals(endsWith(right[i+1]))){
                b[3]=false;
            }
            if(!startsWith(right[i]).equals(startsWith(right[i+1]))){
                b[4]=false;
            }
            if(getPlusMinus(right[i])!=getPlusMinus(right[i+1])){
                b[5]=false;
            }
            if(getLength(right[i])!=getLength(right[i+1])){
                b[6]=false;
            }
        }
        if(isRight(left[0],word,a)){
            return "LEFT";
        }
        if(isRight(right[0],word,b)){
            return "RIGHT";
        }
        return "NEITHER";
        
    }
    public boolean isRight(String a, String b, boolean [] c){
        if(c[0]){
            if(getNumTallLetters(a)!=getNumTallLetters(b)){
                return false;
            }
        }
        if(c[1]){
            if(getNumVowels(a)!=getNumVowels(b)){
                return false;
            }
        }
        if(c[2]){
            if(getNumVowelsWithY(a)!=getNumVowelsWithY(b)){
                return false;
            }
        }
        if(c[3]){
            if(!endsWith(a).equals(endsWith(b))){
                return false;
            }
        }
        if(c[4]){
            if(!startsWith(a).equals(startsWith(b))){
                return false;
            }
        }
        if(c[5]){
            if(getPlusMinus(a)!=getPlusMinus(b)){
                return false;
            }
        }
        if(c[6]){
            if(getLength(a)!=getLength(b)){
                return false;
            }
        }
        return true;
    }
}