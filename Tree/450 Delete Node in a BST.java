class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        //Search
        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else{
            //element found
            
            //Leaf Node
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            //Case 2 Non-Leaf Node
            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }

    TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
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
