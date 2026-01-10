import java.util.Arrays;

public class Prob_108_arrToBinTree {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int arr[] = { -10, -3, 0, 5, 9 };
        obj.sortedArrayToBST(arr);
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

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return DFS(nums, 0, nums.length - 1);
    }

    public TreeNode DFS(int nums[], int low, int high) {
        if (low > high)
            return null;

        int mid = low + (high - low) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = DFS(nums, low, mid - 1);
        node.right = DFS(nums, mid + 1, high);
        return node;
    }
}