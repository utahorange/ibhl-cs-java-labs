import java.lang.*;
import java.util.*;
/**
 * @author  add your name
 */
public class Java8FilteringPractice {
    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *    removes all negative numbers (< 0) from the parameter nums
     *
     *    noNeg([10, -11, 20]) returns [10, 20]
     */
    public static List<Integer> noNeg(List<Integer> nums) {
        nums.removeIf(n->n < 0);
        return nums;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   Given a list of non-negative integers, 
     *     return a list of those numbers
     *     omitting those whose ones place value equals the parameter digit.
     *   you may assume 0 <= digit <= 9
     *
     *   noMatchDigit([10, 13, 57], 3) returns[10, 57]
     */
    public static List<Integer> noMatchDigit(List<Integer> nums, int digit) {
        nums.removeIf(n -> n %10==digit);
        return nums;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   Given a list of strings,
     *     return a list of the strings,
     *     omitting any string length equal to the parameter avoidLength, avoidLength - 1 or avoidLength + 1.
     *
     *   playWithStringLengths(["123", "1234", "12345", "123456"], 4) returns ["123456"]
     */
    public static List<String> playWithStringLengths(List<String> words, int avoidLength) {
        words.removeIf(word -> Math.abs(word.length()-avoidLength) <=1);
        return words;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   Given a list of integers,
     *     return a list of those numbers multiplied by the parameter prod,
     *     omitting any of the resulting numbers that are even.
     *     
     *     This method may/should require using the replaceAll method followed by removeIf
     *
     *   noEven([10, 13 ,57], 3) return [39, 171]
     */
    public static List<Integer> noEven(List<Integer> nums, int prod) {
        nums.replaceAll(n -> n*prod);
        nums.removeIf(n -> n%2==0);
        return nums;
    }

    /*
     *   Remember, the objective of this lab is to use the features provided in Java 8
     *     
     *   Given a list of strings,
     *     return a list where each string has a "th" added to its end, 
     *     omitting any resulting strings that contain the parameter it as a substring anywhere. 
     *     
     *     This method may/should require using the replaceAll method followed by removeIf
     *
     *   playWithStrings(["The", "word", "is", "Computer"], "r") returns ["Theth", "isth"]
     *   playWithStrings(["wi", "bandwid", "zeni"], "ith") returns ["bandwidth"]
     */
    public static List<String> playWithStrings(List<String> words, String it) {
        words.replaceAll(w -> w+"th");
        words.removeIf(w -> w.contains(it));
        return words;
    }
}