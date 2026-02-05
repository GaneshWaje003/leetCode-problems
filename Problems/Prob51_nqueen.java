import java.util.ArrayList;
import java.util.List;

public class Prob51_nqueen {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        int l  = 0;
        List<List<String>> result = s.solveNQueens(9);
        for(List<String> row :result){
            for(String col:row){
                // System.out.println(col + " ");
            }
            l++;
            System.out.println(l);
        }

    }
}

class Solution {

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

    public void backtrack(int n, int row, List<String> board, List<List<String>> result) {

        if (row == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(n, row, col, board)) {

                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                // move to next row
                backtrack(n, row + 1, board, result);

                // backtrack
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();

        String emptyString = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(emptyString);
        }

        backtrack(n, 0, board, result);

        return result;
    }
}
