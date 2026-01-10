package dailyChallenges;

import java.util.HashMap;
import java.util.Map;

public class Prob3346_maximumFrequency {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {1 , 4 , 5};
        obj.maxFrequency(nums, 1, 2);
    }    
}

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int freq = 0;
        
        Map<String , int[]> art = new HashMap<>();
        
        for(int i:nums){
            int[] range = new int[2];
            range[0] = i-k;
            range[1] = i+k;

            System.out.println(range[0] + " -> "+range[1]);
        }



        return freq;

    }
}