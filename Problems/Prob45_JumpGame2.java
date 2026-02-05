public class Prob45_JumpGame2 {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] arr = { 2, 3, 0, 1, 4 };

        s.jump(arr);
        System.out.println(s.jump(arr));
    }
}

class Solution {
    public int jump(int[] nums) {

        int jumps = 0, lastJumpIdx = 0, coverage = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                jumps++;

                if (coverage >= nums.length - 1) {
                    return jumps;
                }
            }
        }

        return jumps;
    }
}