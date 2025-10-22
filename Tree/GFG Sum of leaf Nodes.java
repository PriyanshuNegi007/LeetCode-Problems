class Solution {
    static int leafSum(Node root) {
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        int leftSum = leafSum(root.left);
        int rightSum = leafSum(root.right);
        
        return leftSum + rightSum; 
    }
}

/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
