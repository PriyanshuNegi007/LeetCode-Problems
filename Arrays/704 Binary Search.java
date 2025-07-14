class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;
        while(left<=right){
             int middle = (right+left)/2;
            if(target==nums[middle]){
                return middle;
            }
            else if(target<nums[middle]){
                right=middle-1;
            }
            else if(target>nums[middle]){
                left=middle+1;
            }
        }
        return -1;
    }
}

   /*public int searchRecursion(int[] nums, int target, int left, int right) {
    if (left > right) {
        return -1;
    }

    int middle = (left + right) / 2;

    if (nums[middle] == target) {
        return middle;
    } else if (target > nums[middle]) {
        return searchRecursion(nums, target, middle + 1, right);
    } else {
        return searchRecursion(nums, target, left, middle - 1);
    }
}

}*/
