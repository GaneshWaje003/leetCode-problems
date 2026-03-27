import java.util.ArrayList;
import java.util.List;

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

public class Prob94_binaryInorderTraversal {
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        return solve(root);
    }
    
    public List<Integer> solve(TreeNode root){
        
        List<Integer> result = new ArrayList<>();
        
        // base case (if root becomes null)
        if(root == null) return result; 

        result.addAll(solve(root.left));
        result.add(root.val);
        result.addAll(solve(root.right));
    
        return result;
    }
}

