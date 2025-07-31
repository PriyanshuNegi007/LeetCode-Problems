class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    void shift(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
    public int pop() {
        shift();
        return outStack.pop();
    }
    
    public int peek() {
        shift();
        return outStack.peek();
    }
    
    public boolean empty() {
        if(inStack.isEmpty() && outStack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
