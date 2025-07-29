class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean sameSize = false;

        for(int i = 0; i < asteroids.length; i++){
            sameSize = false;
            while(!stack.isEmpty() && (stack.peek() > 0 && asteroids[i] < 0)){
                if(Math.abs(asteroids[i]) > stack.peek()){
                    stack.pop();
                    continue;
                }
                else if(Math.abs(asteroids[i]) == stack.peek()){ //same size
                    stack.pop();
                }
                sameSize = true;
                break;
            }
            if(!sameSize){
                stack.push(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length-1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
