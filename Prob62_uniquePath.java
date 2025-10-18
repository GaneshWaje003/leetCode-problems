public class Prob62_uniquePath {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.uniquePaths(3, 7);
        System.out.println(result);
    }
}

class Solution {

    public int helper(int m , int n  , int[][] arr , int[][] dp){
        
        System.out.println("m: " + m + " n: " + n );

        if(m == arr.length-1 && n == arr[0].length-1){
            System.out.println("m: " + m + " n: " + n + " match ");
            return 1;
        }

        if( m >= arr.length || n >= arr[0].length){
            System.out.println("m: " + m + " n: " + n + " exit ");
            return 0;
        }

        if(dp[m][n] != -1){
            System.out.println("m: " + m + " n: " + n + " dp used ");
            return dp[m][n];
        }


        int right = helper(m , n + 1 , arr , dp);
        int down = helper(m + 1 , n ,  arr , dp);

        dp[m][n] = right + down;

        return dp[m][n];

    }
    
    
    public int uniquePaths(int m, int n) {
        int result = 0;
        int[][] dp = new int[m][n];
        int[][] dp2 = new int[m][n];

        for(int i =0;i<m;i++){          
            for(int j=0;j<n;j++) dp2[i][j] = -1;
        }
        

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int left = dp[i][j - 1];
                int down = dp[i-1][j];
                dp[i][j] = left + down;
            }
        }
        return dp[m - 1][n - 1];
    

        
        // return helper(0 , 0 , dp , dp2);
    }
}
