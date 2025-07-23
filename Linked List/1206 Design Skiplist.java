class Skiplist {
    private static final int MAX_LEVEL = 16;
    private Node head;
    private int level;
    private Random random;

    class Node{
        int val;
        Node next[];
        Node(int val,int level){
            this.val= val;
            this.next = new Node[level+1];
        }
    }

    private int randomLevel(){
        int level = 0;
        while(level < MAX_LEVEL && random.nextDouble() < 0.5){
            level++;
        }
        return level;
    }

    public Skiplist() {
        this.head = new Node(-1,MAX_LEVEL);
        this.level = 0;
        this.random = new Random();
    }
    
    public boolean search(int target) {
        Node current = head;
        for(int i = level; i >= 0; i--){
            while(current.next[i] != null && current.next[i].val < target){
                current = current.next[i];
            }
        }
        current = current.next[0];
        return current != null && current.val == target;
    }
    
    public void add(int num) {
        Node update[] = new Node[MAX_LEVEL + 1];
        Node current  = head;

        for(int i = level; i >= 0; i--){
            while(current.next[i] != null && current.next[i].val < num){
                current = current.next[i];
            }
             update[i] = current;
        }
        current = current.next[0];

        int newLevel = randomLevel();
        if(newLevel > level){
            for(int i = level + 1; i <= newLevel; i++){
                update[i] = head;
            }
            level = newLevel;
        }
        Node newNode = new Node(num,newLevel);
        for(int i = 0; i <= newLevel; i++){
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }

    }
    
    public boolean erase(int num) {
        Node update[] = new Node[MAX_LEVEL + 1];
        Node current = head;

        for(int i = level; i >= 0; i--){
            while(current.next[i] != null && current.next[i].val < num){
                current = current.next[i];
            }
            update[i] = current;
        }
        current = current.next[0];

        if(current == null || current.val != num){
            return false;
        }

        for(int i = 0; i <= level; i++){
            if (update[i].next[i] != current){
                break;
            } 
            update[i].next[i] = current.next[i];
        }

        while(level > 0 && head.next[level - 1] == null){
            level--;
        }
        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
