// Singly Linked List
class Node{
    int data; // contains the data of a Node
    Node next;  // contains the address of the next node
    // Constructor - Constructor will call when u create object of a Node
    // Constructor will init member of the class
    Node(int data){
        this.data = data;
    }
}

class MyLinkedList {
    Node head; // head reference variable create, by default null
    // null - no reference
    int size; 
    public MyLinkedList() {
        size = 0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1 ;
        }
        if(head == null){
            return -1;
        }
        Node temp = head;
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val); // create a new node object
        size++;
        // newNode - contains the address of a new node
        // if there is no Head - LL Empty
        if(head == null){
            head = newNode;
        }
        else{
            // head already exist
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void addAtTail(int val) {
         Node newNode = new Node(val); 
         size++;
         if(head == null){
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    public void addAtIndex(int index, int val) {
        // wrong index
        if(index<0 || index>size){
            return ;
        }
        // add at head
        if(index == 0){
            addAtHead(val);
            return ;
        }
        // add at tail
        if(index == size){
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val); 
         size++;
        Node temp = head;
        // mid add
        for(int i = 0; i<index-1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size){
            return ;
        }
        if(head == null){
            return ;
        }
        if(index ==0){
            head = head.next;
            return ; 
        }
        Node temp = head;
        for( int i = 0; i<index-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
}

// Doubly Linked List
class Node{
    int data; // contains the data of a Node
    Node next;  // contains the address of the next node
    Node prev; //contains the adress of previous node
    // Constructor - Constructor will call when u create object of a Node
    // Constructor will init member of the class
    Node(int data){
        this.data = data;
    }
}

class MyLinkedList {
    Node head; // head reference variable create, by default null
    // null - no reference
    int size; 
    public MyLinkedList() {
        size = 0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1 ;
        }
        if(head == null){
            return -1;
        }
        Node temp = head;
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val); // create a new node object
        size++;
        // newNode - contains the address of a new node
        // if there is no Head - LL Empty
        if(head == null){
            head = newNode;
        }
        else{
            // head already exist
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void addAtTail(int val) {
         Node newNode = new Node(val); 
         size++;
         if(head == null){
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    
    public void addAtIndex(int index, int val) {
        // wrong index
        if(index<0 || index>size){
            return ;
        }
        // add at head
        if(index == 0){
            addAtHead(val);
            return ;
        }
        // add at tail
        if(index == size){
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val); 
         size++;
        Node temp = head;
        // mid add
        for(int i = 0; i<index-1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size || head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return;
        }

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        if(temp.prev != null) {
            temp.prev.next = temp.next;
        }

        if(temp.next != null) {
            temp.next.prev = temp.prev;
        }

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
