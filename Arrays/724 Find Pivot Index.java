class Solution {
    public int pivotIndexBruteForce(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int leftSum = 0;
            //for left sum
            for(int j = 0; j < i; j++){
                leftSum = leftSum + nums[j];
            }
            int rightSum = 0;
            //For RightSum
            for(int k = i + 1; k < nums.length; k++){
                rightSum = rightSum + nums[k];
            }
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum = sum + i;
        }
        int leftSum=0;
        for(int j = 0; j < nums.length; j++){
            int rightSum = sum - leftSum - nums[j];
            if(leftSum == rightSum){
                return j;
            }
            leftSum = leftSum + nums[j];
        }
        return -1;
    }
}
