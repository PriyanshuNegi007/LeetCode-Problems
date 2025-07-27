class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for(String currentPath: paths){
            if(currentPath.equals(".") || currentPath.trim().length() == 0){
                continue;
            }
            else if(currentPath.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(currentPath);
            }
        }
        StringBuilder canonPath = new StringBuilder();
        for(String currentPath: stack){
            canonPath.append("/");
            canonPath.append(currentPath);
        }
        return canonPath.toString().length()> 0 ? canonPath.toString():"/";
    }
}
