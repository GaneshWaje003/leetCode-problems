import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob73_placeZeros {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        Solution s = new Solution();
        s.setZeroes(matrix);

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}

class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        // List<List<Integer>> zeroPlaces = new ArrayList<>();

        // for(int i = 0 ; i < m ;i++){
        // for(int j = 0 ; j < n ;j++){
        // if(matrix[i][j] == 0){
        // zeroPlaces.add(Arrays.asList(i , j));
        // }

        // }
        // }

        // System.out.println(zeroPlaces);

        // // iterate over the collected zero positions and set entire row and column to
        // 0
        // for (List<Integer> pos : zeroPlaces) {
        // int r = pos.get(0);
        // int c = pos.get(1);

        // // zero the row r
        // for (int col = 0; col < n; col++) {
        // matrix[r][col] = 0;
        // }
        // // zero the column c
        // for (int row = 0; row < m; row++) {
        // matrix[row][c] = 0;
        // }
        // }

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = cols[j] = true;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0 ;
                }

            }
        }



    }
}