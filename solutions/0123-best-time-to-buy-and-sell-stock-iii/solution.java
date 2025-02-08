class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n][2][3]; // why 3d -dp ?? because we have
											// transactions variable
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int canBuy = 1;
		int maxTransactions = 2;

		return solve(0, prices, canBuy, maxTransactions, dp);
	}

	private int solve(int index, int[] prices, int canBuy, int maxTransactions,
			int[][][] dp) {
		if (index >= prices.length || maxTransactions == 0) {
			return 0;
		}

		if (dp[index][canBuy][maxTransactions] != -1) {
			return dp[index][canBuy][maxTransactions];
		}

		int maxProfit = 0;
		if (canBuy == 1) {
			int buy = -prices[index]
					+ solve(index + 1, prices, 0, maxTransactions, dp);
			int notBuy = solve(index + 1, prices, 1, maxTransactions, dp);
			maxProfit = Math.max(buy, notBuy);
		} else {
			int sell = prices[index]
					+ solve(index + 1, prices, 1, maxTransactions - 1, dp);
			int notSell = solve(index + 1, prices, 0, maxTransactions, dp);
			maxProfit = Math.max(sell, notSell);
		}

		return dp[index][canBuy][maxTransactions] = maxProfit;
	}
}
