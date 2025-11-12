class Tree {
    ArrayList<Integer> Kdistance(Node root, int k) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            if(level == k){
                for(int i = 0; i < size; i++){
                    resultList.add(queue.poll().data);
                } 
                return resultList;
            }
            
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return resultList;
    }
}

/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
