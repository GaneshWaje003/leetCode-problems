import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob47_permutation2 {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
        System.out.println(solution.permuteUnique(nums));
    }
}

class Solution {

    public void permuteHelper(List<List<Integer>> result, List<Integer> tempList, int[] nums , boolean[] used) {

        // base case
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // recursive case
        for (int i = 0; i < nums.length; i++) {

            // skip duplicates
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1])
                continue;

            // add element
            tempList.add(nums[i]);
            used[i] = true;

            // recursive call
            permuteHelper(result, tempList, nums , used);

            // backtracking
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used  = new boolean[nums.length];
        permuteHelper(result, new ArrayList<>(), nums , used);
        return result;
    }
}