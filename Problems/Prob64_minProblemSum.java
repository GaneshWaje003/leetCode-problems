public class Prob64_minProblemSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1},
        };

        Solution s = new Solution();
        System.out.println(s.minPathSum(grid));
    }
}

class Solution {

    private int helper(int[][] grid , int m , int n){
        if( m == grid.length || n == grid[0].length){
            return grid[m-1][n-1];
        }

        if( m > grid.length || n > grid[0].length){
            return Integer.MAX_VALUE;
        }

        int down = helper(grid , m-1 , n );
        int right = helper(grid , m , n-1 );

        return Math.min(down , right) + grid[m][n];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        helper(grid , m , n );

        // create a dp 
        int [][] dp = new int[m][n];

        // initialize the first row 
        dp[0][0] = grid[0][0];
        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
            System.out.println(i + "  row : " + dp[0][i]);
        }

        // initialize the first column
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
            System.out.println(i + "  col : " + dp[i][0]);
        }

        // fill the dp table
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]= Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                System.out.println("dp : i=" + i + " j=" + j + " dp[i][j]=" + dp[i][j]);
            }
        }

        return dp[m-1][n-1];
    }
}