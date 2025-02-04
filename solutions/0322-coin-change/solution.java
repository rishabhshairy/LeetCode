class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
		int[][] dp = new int[n][amount + 1];

		// base case when we have last coin in array coins[0]

		for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
			if (currentAmount % coins[0] == 0) {
				dp[0][currentAmount] = currentAmount / coins[0];
			} else {
				dp[0][currentAmount] = (int) Math.pow(10, 9);
			}
		}

		// form loops
		for (int i = 1; i < n; i++) {
			for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
				int notTake = dp[i - 1][currentAmount];
				int take = (int) Math.pow(10, 9);
				if (coins[i] <= currentAmount) {
					take = 1 +  dp[i][currentAmount - coins[i]];
				}
				dp[i][currentAmount] = Math.min(take, notTake);
			}
		}

		return dp[n - 1][amount] != Math.pow(10, 9) ? dp[n - 1][amount] : -1;
    }
}
