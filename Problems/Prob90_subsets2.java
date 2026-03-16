import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob90_subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // first sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {

        // add current list
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;

            // chose element
            temp.add(nums[i]);

            // recursive call
            helper(nums, result, temp, i + 1);

            // backtrack
            temp.remove(temp.size() - 1);
        }

    }
    public static void main(String[] args) {

    }
}
