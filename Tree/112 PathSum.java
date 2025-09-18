class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helperSum(root,targetSum,0);
    }

    boolean helperSum(TreeNode root, int targetSum, int sum){
        if(root == null){ // Base Case
            return false;
        }
        sum = sum + root.val;
        // Leaf Node
        if(root.left == null && root.right == null){
            return sum == targetSum;
        }

        //Move to left
        boolean leftResult = helperSum(root.left, targetSum, sum);

        //Move to right
        boolean rightResult = helperSum(root.right, targetSum, sum);

        return leftResult || rightResult;
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
