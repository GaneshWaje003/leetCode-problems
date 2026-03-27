import java.util.ArrayList;
import java.util.List;

public class Prob95_uniqueBinarySearchTree {

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<TreeNode> res = sol.generateTrees(10);

        
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {
        
        List<TreeNode> result = new ArrayList<>();

        int[] arr = new int[n];

        for(int i = 1 ; i <= n ; i ++)  arr[i] = i;

        return solve(1 , n);
    }

    public List<TreeNode> solve(int start , int end){

        List<TreeNode> res = new ArrayList<>();

        // base case 
        if(start > end){   
            res.add(null);
            return res;
        }


        for(int i = start; i <= end; i++){
            
            List<TreeNode> lefts = solve(start , i - 1);
            List<TreeNode> rights = solve(i + 1 , end);

            for(TreeNode it : lefts)
                for(TreeNode r:rights)
                    res.add(new TreeNode(i , it , r)); // new root per combo 

        }


        return res;
    }
}