class Solution {
    //Approach 1
    public int[] runningSumApproach1(int[] nums) {
        int [] prefix = new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        return prefix;
    }
    //Approach 2
    public int[] runningSum(int[] nums) {
        for(int i=1; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
