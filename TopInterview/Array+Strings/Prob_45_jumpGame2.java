// package TopInterview.Array+Strings;

public class Prob_45_jumpGame2 {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 1, 4 };
        Solution sol = new Solution();
        System.out.println(sol.jump(arr));
    }
}

class Solution {
    public int jump(int[] nums) {

        if (nums.length <= 1)
            return 0;

        int jumps = 0, currentEnd = 0, maxReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
    
        }
        return jumps;
    }
}