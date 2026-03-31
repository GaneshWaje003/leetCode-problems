import java.util.ArrayList;
import java.util.List;

public class Prob100_sameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    
        return PreOrder(q, new ArrayList<>()) .equals(PreOrder(p, new ArrayList<>()));

    }

    private boolean DFS(TreeNode p , TreeNode q){

        // base case if both are null then they are same
        if(p == null && q == null) return true;

        // if 1 is null and other not then no same 
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        // reecursive case : check left and right subtree
        return DFS(p.left , q.left) && DFS(p.right , q.right);

    }


    private List<Integer> PreOrder(TreeNode root , List<Integer> list){
        if(root == null) return list;

        list.add(root.val);
        list.addAll(PreOrder(root.left , list));
        list.addAll(PreOrder(root.right , list));
        return list;
    }

}
