class Solution {
    public double findMaxAverageBruteForce(int[] nums, int k) {
        double maxAverage = Double.NEGATIVE_INFINITY;

        for(int i = 0; i <= nums.length - k; i++){
            double sum = 0;
            for(int j = i; j < i+k; j++){
                sum = sum + nums[j];
            }
            maxAverage = Math.max(maxAverage,(double)sum/k);
        }
        return maxAverage;
    }
    //Sliding WIndow
    public double findMaxAverage(int[] nums, int k){
        int sum = 0;
        //Pick first k sum
        for(int i = 0; i < k; i++){
            sum = sum + nums[i];
        }
        double maxAverage = (double)sum/k;
        for(int j = k; j < nums.length; j++){
            sum = sum + nums[j] - nums[j - k];
            maxAverage = Math.max(maxAverage,(double)sum/k);
        }
        return maxAverage;
    }
}
