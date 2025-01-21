class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
		int maxSell = 0;

		for (int i = 1; i < prices.length; i++) {

			int sellCost = prices[i] - minBuy;
			maxSell = Math.max(maxSell, sellCost);
			minBuy = Math.min(minBuy, prices[i]);

		}
		return maxSell;
    }
}
