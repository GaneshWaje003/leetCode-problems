public class RotateArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        s.rotate(arr, k);
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums ,int start , int end ){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}