import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

public class Prob102_btLevelorderTraversal {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node5, null);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode root = new TreeNode(1, node2, node3);

        Prob102_btLevelorderTraversal s = new Prob102_btLevelorderTraversal();
        s.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        return LevelOrderHelper(root, 0);
    }

    private List<List<Integer>> LevelOrderHelper(TreeNode root, int level){

        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        // bse case (leaf node is reached or root is null)
        if(root == null) return result;


        // first add the root 
        q.offer(root);

        // no loop till q is not empty 
        while(!q.isEmpty()){

            // get size 
            int size = q.size();

            // create a list to store in the current level 
            List<Integer> list = new ArrayList<>();

            //for loop till size 
            for(int i =0 ;i < size; i++){
                
                // get the node
                TreeNode node = q.poll();

                // add the values to list 
                list.add(node.val);

                // add next levels node 
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            
            
            }

            // add the list to result
            result.add(list);


        }

        return result;
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