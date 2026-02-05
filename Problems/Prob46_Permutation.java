import java.util.ArrayList;
import java.util.List;

public class Prob46_Permutation {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1, 2, 3 };

        s.permute(arr);
        System.out.println(s.permute(arr));
    }
}

class Solution {

    public void permuteHelper(List<List<Integer>> result , List<Integer> tempList , int[] nums){
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            permuteHelper(result, tempList, nums);
            
            // backtracking 
            tempList.remove(tempList.size()-1); 
        }
    }
    

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(result , new ArrayList<>(), nums);
        return result;

    }
}