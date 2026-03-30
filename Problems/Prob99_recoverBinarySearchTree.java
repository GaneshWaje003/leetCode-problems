public class Prob99_recoverBinarySearchTree {

    public static void main(String[] args) {
        Prob99_recoverBinarySearchTree obj = new Prob99_recoverBinarySearchTree();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode root = new TreeNode(1);

        root.left = node1;
        node1.right = node2;

        obj.recoverTree(root);

    }

    public void recoverTree(TreeNode root) {
        solve(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private TreeNode prev = null;
    private TreeNode first = null;
    private TreeNode second = null;

    public boolean solve(TreeNode root) {

        // base case ( all went good and found no problem )
        if (root == null)
            return true;

        // recursive case ( at fist go for left side )
        solve(root.left);

        // actual bst check and storing the nodes which are not in order
        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev;
            second = root;
        }

        // storing the prev node for next iteration
        prev = root;

        // recursive case ( now going for right side)
        return solve(root.right);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
