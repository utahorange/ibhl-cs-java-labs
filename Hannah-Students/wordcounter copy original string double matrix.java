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
    private String[][] myLetters;

    /**
     * Constructor for objects of class TearCalculator
     */
    public WordCounter(String[] letters)
    {
      int maxCol=0;
      int maxRow=letters.length;
      for(int r = 0;r<letters.length;r++){
        if(letters[r].length()>maxCol){
          maxCol = letters[r].length();
        }
      }
      myLetters = new String[maxRow][letters.length];
      for(int r = 0;r<letters.length;r++){
        for(int c=0;c<letters[r].length();c++){
          myLetters[r][c]=letters[r].substring(c,c+1);
        }
      }
    }
    public int countEmAll(String target){
      int total = 0;
      for (int i = 0; i < myLetters.length; i++)
         for (int j = 0; j < myLetters[i].length; j++)
            total = countWord(total,i,j,target);
      return total;
    }
    private int countWord(int total, int row, int col, String target) {
      if(target.length()==0){ // found end of string
        return 1;
      }else if(myLetters[row][col].equals(target.substring(0,1))){
        for(int i=-1;i<2;i+=2){
          for(int j=-1;j<2;j+=2){
            if(row+i<=myLetters.length && row+i>=0 && col+i<=myLetters[row+i].length && col+i>=0){
                countWord(total, row+i,col+i,target.substring(1,target.length()));
            }
          }
        }
      }else{
        return 0;
      }
      return total;
    }
}