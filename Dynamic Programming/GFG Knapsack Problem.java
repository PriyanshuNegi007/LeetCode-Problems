class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        return helper(W, val, wt, 0, val.length); // 0 is index 
    }
    // Brute Force
    static int helper(int W, int val[], int wt[], int currentIndex, int length){
        //Base Case
        if(currentIndex == length){
            return 0;
        }
        
        if(W == 0){
            return 0;
        }
        // Leave it
        int valueAfterLeave = helper(W, val, wt, currentIndex + 1, length);
        
        int valueAfterTake = 0;
        //Pick it
        if(wt[currentIndex] <= W){
            valueAfterTake = val[currentIndex] + helper(W - wt[currentIndex], val, wt, currentIndex + 1, length);
        }
        
        //Check which gives max value
        return Math.max(valueAfterLeave, valueAfterTake);
    }
}
