import java.util.Scanner;
class Solution {
    /*public static int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                   return new int[]{i,j};
                }

            }
         
        }
        return new int[]{};
    }  */
    // 2 Pointer Approach
    public static int[] twoSum(int[] nums, int target) {
        int aux[] = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);

        int i=0;
        int j=nums.length-1;

        int first=-1;
        int second=-1;

        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                first = nums[i];
                second = nums[j];
                break;
            }
            else if(sum > target){
                j--;
            }
            else if(sum < target){
                i++;
            }
        }

        int firstIndex = -1;
        int secondIndex = -1;

        for( i = 0; i < aux.length; i++){
            if(firstIndex == -1 && aux[i] == first){
                firstIndex = i;
            }
            else if(secondIndex == -1 && aux[i] == second){
                secondIndex = i;
            }
        }
        return new int[]{firstIndex,secondIndex};
    }
}
