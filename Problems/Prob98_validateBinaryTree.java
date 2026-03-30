public class Prob98_validateBinaryTree {
    
    public boolean isValidBST(TreeNode root) {
        return solve(root);
    }

    private long prev = Long.MIN_VALUE;

    public boolean solve(TreeNode root){
        
        // base case all went throught and found no problem 
        if(root == null) return true;

        // if left is greater than root then return false
        if(!solve(root.left)) return false;        

        // for inorder traversal prev should be always smaller than root if not return false
        if(root.val <= prev) return false;

        // this part is only reached if left is smaller than root and 
        // we are now checking if right is greater than root

        prev = root.val;

        return solve(root.right);
    }
}
