public class Prob75_sortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        Solution solution = new Solution();
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}


class Solution {
    public void sortColors(int[] nums) {
        

        for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]< nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }


        // int low = 0;
        // int mid = 0;
        // int high = nums.length - 1;

        // while (mid <= high) {
        //     if (nums[mid] == 0) {
        //         // Swap nums[low] and nums[mid]
        //         int temp = nums[low];
        //         nums[low] = nums[mid];
        //         nums[mid] = temp;
        //         low++;
        //         mid++;
        //     } else if (nums[mid] == 1) {
        //         mid++;
        //     } else { // nums[mid] == 2
        //         // Swap nums[mid] and nums[high]
        //         int temp = nums[mid];
        //         nums[mid] = nums[high];
        //         nums[high] = temp;
        //         high--;
        //     }
        // }


    }
}