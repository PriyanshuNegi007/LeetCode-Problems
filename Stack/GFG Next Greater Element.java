class Solution {
    public ArrayList<Integer> nextLargerElements(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        
        
        for(int i = 0; i < n; i++){
            boolean isFound = false;
            for(int j = i + 1; j < n; j++){
                if(arr[j] > arr[i]){
                    isFound = true;
                    list.add(arr[j]);
                    break;
                }
            }
            if(!isFound){
                list.add(-1);
            }
        }
        return list;
    }
    
    public ArrayList<Integer> nextLargerElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length - 1;
        for(int i = n; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            list.add(stack.isEmpty()? -1: stack.peek());
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }
}
