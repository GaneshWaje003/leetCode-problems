import java.util.ArrayList;
import java.util.List;

public class Prob77_combinations {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1,  n, k);
        return result;
    }


    public void backtrack(List<List<Integer>> result , List<Integer> current , int start ,  int n , int  k){

        // base case 
        if(current.size() == k ){
            result.add(new ArrayList<>(current));
            return ;
        }

        // choice : add no. from start to end 
        for(int i = start ; i <= n ;i++){
            current.add(i); // choose 
            backtrack(result, current, i+1, n, k);  // explore (skip duplicates via i +1 )
            current.remove(current.size()-1);
        }
        
    }
}