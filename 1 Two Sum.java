import java.util.Scanner;
class Solution {
    Scanner sc=new Scanner(System.in);
    public static int[] twoSum(int[] nums, int target) {

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                   return new int[]{i,j};
                }

            }
         
        }
        return new int[]{};
    }
}
