public class Prob55_jumpGame {
    public static void main(String[] args) {
        int[] nums = {2,0};

        Solution s = new Solution();
        System.out.println(s.canJump(nums));
    }
}

class Solution {
    public boolean canJump(int[] nums) {

        
        int maxReach = 0 , size = nums.length - 1, i = 0;
        if(size == 0) return true;
        
        System.out.println("size : " + size);

        for (i =0; i <= size; i++) {            
            
            if(i > maxReach){
                return false;
            }
            
            maxReach = Math.max(maxReach , nums[i]+i);

            if(maxReach >= size) return true;

        }

        return false;
    }
}