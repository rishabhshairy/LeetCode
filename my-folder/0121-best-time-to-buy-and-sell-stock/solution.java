class Solution {
    public int maxProfit(int[] prices) {
        int minElem = prices[0];
		int cost = 0;
		int maxCost = 0;

		for (int i = 0; i < prices.length; i++) {
			minElem = Math.min(minElem, prices[i]);

			cost = prices[i] - minElem;
			maxCost = Math.max(maxCost, cost);
		}
        return maxCost;
    }
}
