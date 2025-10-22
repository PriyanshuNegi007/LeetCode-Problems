// Count total nodes in a binary tree
class Solution {
    public static int countNodes(Node root) {
        if(root == null){
            return 0;
        }
        
        int count = 1;
        
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
    }
}
