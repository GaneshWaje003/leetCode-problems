public class Prob3070_countSubmatricesWithTop_left {
    
}

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0 ; 
        
        int[][] preSum = new int[rows+1][cols+1]; 

        for(int i = 1 ; i <= rows;i++){
            for (int j = 1; j <= cols; j++) {
                preSum[i][j] = 
                preSum[i-1][j] + 
                preSum[i][j-1] - 
                preSum[i-1][j-1] + grid[i-1][j-1];
                
                if(preSum[i][j] <= k){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;

    }
}