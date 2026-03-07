// package TopInterview.1D_DP;

import java.util.HashMap;
import java.util.Map;

public class Prob70_climbingStars {
    
    Map<Integer,Integer> memo = new HashMap<>();
    
    public static void main(String[] args) {
        
    }

    public int climbStairs(int n) {
       return helper(n);
    }

    public int helper(int n){
        if(n == 0 || n == 1) return 1;

        if(memo.containsKey(n)) return memo.get(n);

        int result = helper(n-1) + helper(n-2);

        memo.put(n,result);

        return result;
    }
}



