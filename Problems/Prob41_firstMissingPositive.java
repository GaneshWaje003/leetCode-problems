import java.lang.reflect.Array;

public class Prob41_firstMissingPositive {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int arr[] = {3,9,4,1};
        System.out.println(obj.firstMissingPositive(arr));
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for(int i=0;i<n;i++){
            while(nums[i] > 0 && nums[i] < n && nums[nums[i]-1] != nums[i]){
                int correctIndex = nums[i]-1;
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
        }
        
        for (int i : nums) {
            System.out.print(i+" ");
        }
        for(int i =0;i<=n;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return n+1;

    }
}