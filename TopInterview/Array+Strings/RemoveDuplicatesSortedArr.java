public class RemoveDuplicatesSortedArr {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2 };
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(arr));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;

    }
}