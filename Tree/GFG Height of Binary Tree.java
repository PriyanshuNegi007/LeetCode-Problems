class Solution {
    int height(Node node) {
        
        //Approach 1 DFT
        if(node == null){
            return -1; 
        }
        int left = height(node.left);
        int right = height(node.right);
        int max = Math.max(left,right);
        return max + 1;
    }
}

/*
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
