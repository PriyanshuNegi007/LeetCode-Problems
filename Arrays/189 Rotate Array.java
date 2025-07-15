class Solution {
    public void rotateBruteForce(int[] nums, int k) {
       for(int j = 0; j < k; j++){
            int lastElement = nums[nums.length-1];

            for(int i = nums.length-2; i >=0; i--){
            nums[i+1] = nums[i];
            }

            nums[0] = lastElement;
       }
    }

    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}
