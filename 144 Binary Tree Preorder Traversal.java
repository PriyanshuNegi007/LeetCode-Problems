class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preOrderIteration(root);
    }
    //T(C) = O(N)
    void preOrderRecursion(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }

        result.add(root.val);
        preOrderRecursion(root.left,result);
        preOrderRecursion(root.right,result);

    }

    public List<Integer> preOrderIteration(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            list.add(currentNode.val);
            //push right first in stack then left
            if(currentNode.right != null){
                stack.push(currentNode.right);
            }
            if(currentNode.left != null){
                stack.push(currentNode.left);
            }
        }
        return list;
    }
}

/* Definition for a binary tree node.
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
