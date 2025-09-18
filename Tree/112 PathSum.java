class Pair{
    TreeNode node;
    int currentSum;

    Pair( TreeNode node, int currentSum){
        this.node = node;
        this.currentSum = currentSum;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
       // return helperSum(root,targetSum,0);

        // Approach 3
        if(root == null){
            return false;
        }
        //On each node minus node value from targetSum
        targetSum = targetSum - root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        //move to left
        boolean left = hasPathSum(root.left,targetSum);

        //move right
        boolean right = hasPathSum(root.right,targetSum);

        return left || right;
    }

    // Approach 1 - Recursion
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

    // Approach 2 - Iterative
    boolean helperIterative(TreeNode root,int targetSum){
        if(root == null){
            return false;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,0));
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int currentSum = pair.currentSum;
            currentSum = currentSum + node.val;
            // Check Leaf Node
            if(node.left == null && node.right == null){
                if(currentSum == targetSum){
                    return true;
                }
            }
            if(node.left != null){
                stack.push(new Pair(node.left, currentSum));
            }
            if(node.right != null){
                stack.push(new Pair(node.right, currentSum));
            }
        }
        return false;
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
