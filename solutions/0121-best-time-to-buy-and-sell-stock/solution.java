class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int costDiff = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            costDiff = prices[i] - minPrice;
            maxProfit = Math.max(costDiff, maxProfit);
        }

        return maxProfit;
    }
}
