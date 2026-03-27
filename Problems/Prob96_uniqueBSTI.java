public class Prob96_uniqueBSTI {
    
    public static void main(String[] args) {
        
    }
    
    public int numTrees(int n) {
       

        int[] dp = new int[n +1];

        // baes case 
        dp[0] = 1; 
        dp[1] = 1;
        
        for(int i = 2 ;i <= n ; i++){            
            for (int j = 1; j <= i; j++) {
                
                int leftTrees = dp[j - 1];
                int rightTree = dp[i - j];

                dp[i] += leftTrees  * rightTree;
            }
        }

        return dp[n];

    }
}