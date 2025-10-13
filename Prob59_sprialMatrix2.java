public class Prob59_sprialMatrix2 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];
        int top = 0, bottom = n - 1, right = n - 1, left = 0;
        int count = 1;

        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                result[top][i] = count++;
            }
            top++;

            // top bottom
            for(int i = top ; i<= bottom ;i++){
                result[i][right] = count++;
            }
            right--;

            // right ->left 
            for(int i = right; i >= left ;i--){
                result[bottom][i] = count++;
            }
            bottom--;

            //bottom up 
            for(int i = bottom ;i >= top ;i--){
                result[i][left] = count++;
            }
            left++;
        }

        return result;
    }
}