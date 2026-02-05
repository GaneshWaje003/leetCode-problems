import java.util.ArrayList;
import java.util.List;

public class Prob78_subsets {
    public static void main(String[] args) {
        int nums[] = {1 ,2  , 3};
        Solution s = new Solution();
        s.subsets(nums);
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
           
        List<List<Integer>> result  = new ArrayList<>();
        int n  = nums.length;
        Helper(result , new ArrayList<>() , nums , 0 , n);
        
        System.out.println(result);
        return result;

    }

    public void Helper(List<List<Integer>> result , List<Integer> current , int[] nums , int start , int end ){

        //base case : every current state is valid subset 
        result.add(new ArrayList<>(current));
       

        // explore
        for(int i = start ; i < end ; i++){ 
            current.add(nums[i]);
            Helper(result, current, nums, i+1, end);
            current.remove(current.size()-1);

        }

    }
}