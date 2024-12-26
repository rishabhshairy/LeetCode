class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();

		int diff = totalSum - target;

		// chck for edge cases
		if (diff < 0 || diff % 2 != 0) {
			return 0;
		}

		int k = (diff / 2);
		int n = nums.length;
		// declare dp array

		int[][] dp = new int[n][k + 1];

		// base case
		// for sum 0, 1st col will be 1
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		// if we reach last element and its less than target ret 1
		if (nums[0] <= k) {
			dp[0][nums[0]] = 1;
		}
		// for zero at begining ret2
		if (nums[0] == 0) {
			dp[0][0] = 2;
		}

		for (int index = 1; index < dp.length; index++) {
			for (int j = 0; j <= k; j++) {
				int notPick = dp[index - 1][j];
				int pick = 0;
				if (nums[index] <= j) {
					pick = dp[index - 1][j - nums[index]];
				}

				dp[index][j] = notPick + pick;
			}

		}
		return dp[n - 1][k];
    }
}
