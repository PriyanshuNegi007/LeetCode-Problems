class Solution {
    public boolean backspaceCompare(String s, String t) {
        String first = remainInStack(s);
        String second = remainInStack(t);

        return first.equals(second);
    }
    String remainInStack(String s){
        StringBuilder stack = new StringBuilder();
        for(char singleChar: s.toCharArray()){
            if(singleChar != '#'){
                stack.append(singleChar);
            }else if(stack.length() > 0){
                stack.deleteCharAt(stack.length() - 1);
            }
        }
        return stack.toString();
    }
}
