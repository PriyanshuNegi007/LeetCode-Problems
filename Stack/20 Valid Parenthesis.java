class Solution {
    private static boolean compareOpeningAndClosing(char openingBracket, char closingBracket){
        if((openingBracket == '(' && closingBracket == ')') ||
         (openingBracket == '{' && closingBracket == '}') || 
         (openingBracket == '[' && closingBracket == ']')){
            return true;
        }
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char singleBracket: s.toCharArray()){
            if(singleBracket == '{' || singleBracket == '[' || singleBracket == '('){
                stack.push(singleBracket);
            }
            else if(!stack.isEmpty() && compareOpeningAndClosing(stack.peek(),singleBracket)){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
