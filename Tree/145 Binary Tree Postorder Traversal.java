class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //postOrderRecursion(list,root);
        //return list;
        return postOrderIteration(root);
    }

    void postOrderRecursion(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }
        postOrderRecursion(list,root.left);
        postOrderRecursion(list,root.right);
        list.add(root.val);
    }

    List<Integer> postOrderIteration(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            list.add(0,currentNode.val); //to add at last
            if(currentNode.left != null){
                stack.push(currentNode.left);
            }
            if(currentNode.right != null){
                stack.push(currentNode.right);
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
