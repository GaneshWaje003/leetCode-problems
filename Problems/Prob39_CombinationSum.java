import java.util.ArrayList;
import java.util.List;

public class Prob39_CombinationSum {

    public static void main(String[] args) {   
        List<List<Integer>> result = new ArrayList<>();
        Solution obj = new Solution();
        int arr[] = {2,3,5};
        int target = 8;

        result = obj.combinationSum(arr,target);

        for (List<Integer> innerList : result) {
            for (Integer num : innerList) {
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }
}

class Solution {

    public void backtrack(List<List<Integer>> result , List<Integer> tempList, int arr[] ,int remain , int start ){

        if(remain < 0 ){
            return;
        }else if(remain == 0){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i = start;i<arr.length;i++){
                tempList.add(arr[i]);
                backtrack(result, tempList, arr, remain - arr[i], i);
                tempList.remove(tempList.size()-1);
            }
        }

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
}
