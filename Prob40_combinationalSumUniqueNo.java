import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob40_combinationalSumUniqueNo {
    public static void main(String[] args) {

        Solution obj = new Solution();
        int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
        List<List<Integer>> result = obj.combinationSum2(arr, 8);

        for (List<Integer> innList : result) {
            for (Integer num : innList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class Solution {

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int arr[], int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < arr.length; i++) {
                if (i > start && arr[i] == arr[i - 1]) continue;
                tempList.add(arr[i]);
                backtrack(result, tempList, arr, remain - arr[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
}