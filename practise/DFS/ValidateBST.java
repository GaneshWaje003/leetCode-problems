public class ValidateBST {
    public static void main(String[] args) {
            
    }

    public boolean isValidBST(TreeNode root) {
        return DFS(root);    
    }

    private Integer prev = null;

    public boolean DFS(TreeNode root){

        // base case 
        if(root == null) return true;

        // test case 
        if(!DFS(root.left)){
            return false;
        }

        // checking ir right is greater 
        if(prev != null && root.val <= prev) return false;

        prev = root.val;

        return DFS(root.right);
    }
}
