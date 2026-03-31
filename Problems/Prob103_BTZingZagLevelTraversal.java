import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob103_BTZingZagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return solve(root);
    }

    private List<List<Integer>> solve(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        // base case 
        if (root == null) {
            return ans;
        }

        // insert root to q
        q.offer(root);

        // boolean to keep track of zig zag order 
        boolean dir = true ;
        
        // go till q is not empty 
        while(!q.isEmpty()){

            // get size 
            int size = q.size();

            // create list to store current level nodes;
            List<Integer> list = new ArrayList<>();

            // iterate for size times 
            for(int i =0 ; i <size; i++){

                TreeNode node = q.poll();

                // add next level nodes to q
                list.add(node.val);

                // insert next level 
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

            }
            
            if(!dir){
                Collections.reverse(list);
            }
            
            // add list to ans 
            ans.add(list);
            
            // change directions 
            dir = !dir;

        }


        return ans;


        
    }
    
}