public class Prob79_wordSearch {
    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "SEE";

        Solution sol = new Solution();
        boolean result = sol.exist(board, word);
        System.out.println("Result: " + result);
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {

        int row = board.length , col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                
                if(board[i][j] ==  word.charAt(0) && dfs(board , word , i , j , 0)) 
                    return true;

            }
        }

        return false;

    }

    private boolean dfs(char[][] board , String word , int i , int j , int k){

        // base case : found word
        if( k == word.length()) return true;

        // bound check for mismatch
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
           board[i][j] != word.charAt(k)) {
            return false;
        }

        // mark visited 
        char temp = board[i][j];
        board[i][j] = '#';


        // Explore all 4 directions
        if(dfs(board , word , i+1 , j , k+1)) return true;
        if(dfs(board , word , i , j+1 , k+1)) return true;
        if(dfs(board , word , i-1 , j , k+1)) return true;
        if(dfs(board , word , i, j-1 , k+1)) return true;


        // backtrack 
        board[i][j] = temp;

        return false;
    }



}