class Solution {
    static int dp[][];
    
    public static int knapsack(int W, int val[], int wt[]) {
        dp = new int[val.length + 1][W + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(W, val, wt, 0, val.length); // 0 is index
    }
    
    static int helper(int W, int val[], int wt[], int currentIndex, int length){
        //Base Case
        if(currentIndex == length){
            return 0;
        }
        
        if(W == 0){
            return 0;
        }
        // IF already in cache then don't compute it
        if(dp[currentIndex][W] != -1){
            return dp[currentIndex][W];
        }
    
        // Leave it
        int valueAfterLeave = helper(W, val, wt, currentIndex + 1, length);
        
        int valueAfterTake = 0;
        //Pick it
        if(wt[currentIndex] <= W){
            valueAfterTake = val[currentIndex] + helper(W - wt[currentIndex], val, wt, currentIndex + 1, length);
        }
        //Check which gives max value
        dp[currentIndex][W] =  Math.max(valueAfterLeave, valueAfterTake);
        return dp[currentIndex][W];
    }
}
