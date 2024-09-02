////////////////////////////////////////////////////////////////////////////
//
//    H. Donald Allen            
//
//    Purpose         :  Hannah Counter.
//
//    Interface     :  None
//
//    Side-effects  :  None
//
////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class TearCalculator here.
 * 
 * @author Tai-Yu Chen
 * @version (a version number or a date)
 */
public class WordCounter
{
    // instance variables - replace the example below with your own
    private String[] myLetters;

    /**
     * Constructor for objects of class TearCalculator
     */
    public WordCounter(String[] letters)
    {
      myLetters = letters;
    }
    public int countEmAll(String target){
      int total = 0;
      for (int i = 0; i < myLetters.length; i++)
         for (int j = 0; j < myLetters[i].length(); j++){
            System.out.println(myLetters[i].substring(j,j+1));
            total += countWord(total,i,j,target);
            System.out.println("actualt: "+ total);
        }
      return total;
    }
    private int countWord(int total, int row, int col, String target) {
      if(target.length()==0){ // found end of string
        System.out.println(total+1);return(total+1);
        }else if(target.length()==1 && myLetters[row].substring(col,col+1).equals(target)){
           return total+1;
      }else if(myLetters[row].substring(col,col+1).equals(target.substring(0,1))){
        for(int i=-1;i<2;i+=1){
          for(int j=-1;j<2;j+=1){
            if((i!=0 || j!=0) && row+i<myLetters.length && row+i>=0 && col+j<myLetters[row+i].length() && col+j>=0 && myLetters[row+i].substring(col+j,col+j+1).equals(target.substring(1,2))){
                //System.out.println(target.substring(1,target.length())+ " "+total);
                total = countWord(total, row+i,col+j,target.substring(1,target.length()));
            }
            }
        }
        System.out.println("total after a box: " + total + " was checking around "+ myLetters[row].substring(col,col+1));
        System.out.println("----");
        return total;
      }else{
        return total;
        }
    }
}