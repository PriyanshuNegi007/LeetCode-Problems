class Complete {
   public static int[] Smallestonleft(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}
