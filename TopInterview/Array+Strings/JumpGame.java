public class JumpGame{
    public static void main(String args[]){

        int arrp[] = {2,3,1,1,4};
        Solution s = new Solution();
        System.out.println(s.canJump(arrp));

    }
}

class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReach = 0 ;

        for(int i = 0; i < nums.length;i++){
            if(i > maxReach) return false;
            
            
            maxReach = Math.max(maxReach , i + nums[i]);
            System.out.println("i: " + i + " maxReach: " + maxReach);

            if(maxReach >= nums.length - 1) return true;

        }
        
        return false;
    }
}