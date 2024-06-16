class Solution {
    public int maxProfit(int[] prices) {
		int maxCost = 0;

		for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                maxCost += prices[i] - prices[i-1];
            }
		}
        return maxCost;
    }
}
