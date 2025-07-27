class Solution {
    public String removeDuplicate(String s) {
        Stack<Character> stack = new Stack<>();
        char[] letters = s.toCharArray();
        for(char letter: letters){
            if(stack.size() > 0 && stack.peek() == letter){
                stack.pop();
            }else{
                stack.push(letter);
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        return new StringBuilder(result).reverse().toString();
    }
    // Optimized Approach uwithout using stack
    public String removeDuplicates(String s){
        StringBuilder str = new StringBuilder();
        char[] letters = s.toCharArray();
         for(char letter: letters){
            if(str.length() > 0 && str.charAt(str.length() - 1) == letter){
                str.deleteCharAt(str.length() - 1);
            }else{
                str.append(letter);
            }
        }
        return str.toString();
    }
}
