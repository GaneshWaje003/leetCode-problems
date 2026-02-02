// package TopInterview.Matrix;

public class Prob_36_validSudoku {
    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(board));
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board){
        

        int col = board[0].length; 
        int row = board.length;


        
        // check for rows
        for (int i = 0; i < row; i++) {
            
            // automatically resets s
            boolean[] rowCheck= new boolean[10];


            for (int j = 0; j < col; j++) {

                char ch  = board[i][j];

                if(ch == '.') continue;

                int pos = ch - '0' ;
                
                if(rowCheck[pos]){
                    return false;
                }

                rowCheck[pos] = true;

            }
            System.out.println("");
        }

        return true;
    }

}