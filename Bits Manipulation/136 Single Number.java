class Solution {
    public int singleNumberBitsApproach(int[] nums) {
       int Xor= 0;

       for(int i=0;i<nums.length;i++){
        Xor = Xor ^ nums[i];
       }
       return Xor;
    }
}
