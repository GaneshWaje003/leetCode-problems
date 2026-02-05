import java.util.ArrayList;
import java.util.List;

public class Prob52_nqueenii {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(9));
    }
}

class Solution {

    private int result = 0;

    public boolean isSafe(int n, int row, int col, List<String> board) {

        // vertical
        for (int i = row; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // right side diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // right side diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void backtrack(int n, int row, List<String> board) {

        if (row == n) {
            result = result + 1;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(n, row, col, board)) {

                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                // move to next row
                backtrack(n, row + 1, board);

                // backtrack
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }

    }

    public int solveNQueens(int n) {
        int result = 0;
        List<String> board = new ArrayList<>();

        String emptyString = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(emptyString);
        }

        backtrack(n, 0, board);

        return result;
    }

    public int totalNQueens(int n) {

        solveNQueens(n);

        return result;
    }
}

class Solution2 {
    int result = 0;
    int arr[];

    private boolean isSafe(int row , int col){

        for(int i = 0 ;i<row ;i++){
            if(arr[i] == col || (Math.abs(row-1) == Math.abs(col- arr[i]))){
                return false;
            }   
        }

        return true;
    }

    public void helper(int n ,int row){

        if(row == n){
            result++;
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(row , col)){
                arr[row] = col;
                helper(n, row+1);
            }
        }

    }

    public int totalNQueens(int n) {
        arr = new int[n];

        helper(n , 0);

        return result;
    }
}