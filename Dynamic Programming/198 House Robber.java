class Solution {
    public int rob(int[] nums) {
        Integer cache [] = new Integer[nums.length];
        //return robHelperMemoization(nums, cache, 0);
        return robHelperTabulation(nums);
    }

    // Memoization
    public int robHelperMemoization(int [] money, Integer [] cache, int houseNo){
        // base case
        if(houseNo >= money.length){
            return 0;
        }
        // before computing choice1 and choice2 check cache
        if(cache[houseNo] != null){
            return cache[houseNo];
        }

        int choice1 = money[houseNo] + robHelperMemoization(money, cache, houseNo + 2);

        int choice2 =robHelperMemoization(money, cache, houseNo + 1);

        int result = Math.max(choice1, choice2);
        cache[houseNo] = result;
        return result;
    }

    public int robHelperTabulation(int [] money){
        //Edge Cases
        if(money == null || money.length == 0){
            return 0;
        }

        if(money.length == 1){
            return money[0];
        }

        int dp[] = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0],money[1]);

        for(int i = 2; i < money.length; i++){
            int choice1 = dp[i-2] + money[i];
            int choice2 = dp[i-1];
            int result = Math.max(choice1, choice2);
            dp[i] = result;
        }
        return dp[dp.length - 1];
    }
}
