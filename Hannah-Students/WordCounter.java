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
 * @author Tai-Yu Chen and Aisheek Ghosh
 * @version (a version number or a date)
 * 
 */
public class WordCounter {
    private String[] myLetters;
    public WordCounter(String[] letters) {
        myLetters = letters;
    }
    public int countEmAll(String target) {
        int total = 0;
        for (int i = 0; i < myLetters.length; i++) {
            for (int j = 0; j < myLetters[i].length(); j++) {
                total += countWord(i, j, target, 0, -1, -1);
            }
        }
        return total;
    }
    private int countWord(int row, int col, String target, int index, int prevRow, int prevCol) {
        if (row < 0|| row >= myLetters.length|| col < 0 || col >= myLetters[row].length() ||
        myLetters[row].charAt(col) != target.charAt(index) || (row == prevRow && col == prevCol)) {
            return 0;
        }
        if (index == target.length() - 1) {
            return 1;
        }
        int count = 0;
        int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int dir = 0; dir < 8; dir++) {
            int nextRow = row + dRow[dir];
            int nextCol = col + dCol[dir];
            count += countWord(nextRow, nextCol, target, index + 1, row, col);
        }
        return count;
    }
}