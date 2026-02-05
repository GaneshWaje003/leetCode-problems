import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob53_maxSubArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { -2,1,-3,4,-1,2,1,-5,4 };
        System.out.println(s.maxSubArray(arr));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {

        int currSum = 0 , allTimeHigh = 0;
        currSum = allTimeHigh = nums[0];

        for(int i=1;i<nums.length;i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            allTimeHigh = Math.max(currSum , allTimeHigh);
        }

        return allTimeHigh;

    }
}