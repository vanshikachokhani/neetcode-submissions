class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int profit = 0;

        int minBuy = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            profit = Math.max(profit, prices[i]-minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return profit;
    }
}
