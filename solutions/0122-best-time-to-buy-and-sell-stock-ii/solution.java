class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2]; // n - prices have 2 options buy/notbuy
		for (int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		boolean canBuy = true;

		return findMax(0, canBuy, prices, dp);
	}

	/**
	 * @implNote For buy two flow buy & notBuy for Sell two flows sell & notSell
	 * @param index
	 * @param canBuy
	 * @param prices
	 * @param dp
	 *            TODO
	 * @return
	 */
	private int findMax(int index, boolean canBuy, int[] prices, int[][] dp) {
		if (index == prices.length) {
			return 0;
		}

		if (dp[index][canBuy ? 1 : 0] != -1) {
			return dp[index][canBuy ? 1 : 0];
		}

		int profit = 0;
		if (canBuy) {
			int buy = -prices[index] + findMax(index + 1, false, prices, dp);
			int notBuy = findMax(index + 1, true, prices, dp);
			profit = Math.max(buy, notBuy);
		} else {
			int sell = prices[index] + findMax(index + 1, true, prices, dp);
			int notSell = findMax(index + 1, false, prices, dp);
			profit = Math.max(sell, notSell);
		}

		return dp[index][canBuy ? 1 : 0] = profit;
	}
}
