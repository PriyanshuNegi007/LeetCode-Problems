class Solution {
    void inorderTraversalRecursion(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        inorderTraversalRecursion(root.left,result);
        result.add(root.val);
        inorderTraversalRecursion(root.right,result);
    }

    public List<Integer> inOrderTraversalIteration(TreeNode root){
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            list.add(currentNode.val);
            currentNode = currentNode.right; //Explore right
        }
        return list;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        //inorderTraversalRecursion(root,result);
        //return result;
        return inOrderTraversalIteration(root);
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
