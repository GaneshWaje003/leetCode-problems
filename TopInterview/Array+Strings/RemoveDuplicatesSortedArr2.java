// package TopInterview.Array+Strings;

public class RemoveDuplicatesSortedArr2 {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 2, 3 };
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(arr));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
       
        int n = nums.length;
        
        if (n <= 2) {
            return n;
        }


        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}