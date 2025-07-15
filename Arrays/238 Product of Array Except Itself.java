class Solution {
    public int[] productExceptSelfBruteForce(int[] nums) {
        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    product = product * nums[j];
                }
            }
            result[i] = product; 
        }
        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
    //Calculate left products
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }

    //Calculate right products and multiply with left
    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        result[i] = result[i] * right;
        right = right * nums[i];
    }
    return result;
    }
}
