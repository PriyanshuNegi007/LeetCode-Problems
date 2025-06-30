class Solution {
    /*Top Down Approach
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int result = climbStairs(n-1)+climbStairs(n-2);
        return result;
    }*/

    // Bottom Up Approach
    public int climbStairs(int n){
        if(n <= 1){
            return n;
        }
    
        int dp[]= new int[n+1];

        dp[0]=1;  //Because ther's no zero step
        dp[1]=1;

        for(int i =2;i<=n;i++){
            //climbStairs(n-1)+ climbStaors(n-2)  //Recusive relation
            dp[i]= dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
}
