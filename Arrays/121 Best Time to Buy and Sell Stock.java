class Solution {
    public int maxProfit(int[] prices) {
        /* Brute Force Approach
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j=i+1;j < prices.length; j++){
                if(prices[j]>prices[i]){
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(profit,maxProfit);
                }
            }
        }
        return maxProfit; */

        int lowestPrice=prices[0];
        int maxProfit=0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > lowestPrice){
                int profit = prices[i] - lowestPrice;
                maxProfit = Math.max(maxProfit,profit);
            }
            lowestPrice = Math.min(lowestPrice,prices[i]);
        }
        return maxProfit; 
    }
}
