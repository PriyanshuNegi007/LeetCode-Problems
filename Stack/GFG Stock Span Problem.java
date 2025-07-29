class Solution{
    public ArrayList<Integer> calculateSpan(int[] price){
        int n = price.length;
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && price[stack.peek()] <= price[i]){
                stack.pop();
            }
            int currSpan = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            span.add(currSpan);
            stack.push(i);
        }
        return span;
    }
}
