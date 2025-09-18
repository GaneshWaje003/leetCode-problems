public class Prob48_rotateImage {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // System.out.println(s.rotate(matrix));
        for (int[] row : matrix) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        System.out.println("after rotation --------");
        s.rotate(matrix);
    }
}

class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // reverse each row for proper rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][(n - 1) - j];
                matrix[i][(n - 1) - j] = temp;

            }
        }
    }
}