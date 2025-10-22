class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root,Integer.MIN_VALUE);
    }

    int helper(TreeNode root, int currentMax){
        if(root == null){
            return 0;
        }

        int left = helper(root.left,Math.max(root.val,currentMax));
        int right = helper(root.right,Math.max(root.val,currentMax));
        int result = left + right;

        if(root.val >= currentMax){
            result += 1;
        }
        return result;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
