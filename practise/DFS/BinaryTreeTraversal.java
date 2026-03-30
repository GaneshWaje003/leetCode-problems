import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        // base case if root is null
        if(root == null) return res;

        res.addAll(DFS(root));

        return res;

    }


    public List<Integer> DFS(TreeNode root){

        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        // inorder l , r , r 
        res.addAll(DFS(root.left));
        res.add(root.val);
        res.addAll(DFS(root.right));

        return res;

    }

}
