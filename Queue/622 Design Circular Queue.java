class MyCircularQueue {
    int[] array;
    int front;
    int rear;
    int size;
    int count;

    public MyCircularQueue(int k) {
        size = k;
        array = new int[k];
        front = 0;
        rear = 0;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % size;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % size;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return array[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return array[(rear -1 + size) % size];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }
}
