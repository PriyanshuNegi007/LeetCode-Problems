class Solution {
    public static int findMax(Node root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        int leftValue = findMax(root.left);
        int rightValue = findMax(root.right);
        
        return Math.max(root.data, Math.max(leftValue,rightValue));
    }

    public static int findMin(Node root) {
         if(root == null){
            return Integer.MAX_VALUE;
        }
        
        int leftValue = findMin(root.left);
        int rightValue = findMin(root.right);
        
        return Math.min(root.data, Math.min(leftValue,rightValue));
    }
}

/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
