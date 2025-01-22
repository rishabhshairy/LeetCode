class Solution {
    public boolean canPartition(int[] nums) {
        // step 1 check if sum is even
		int totalSum = Arrays.stream(nums).sum();
		if (totalSum % 2 != 0) {
			return false;
		}

		int sum = totalSum / 2;
		int n = nums.length;
		// now apply subset sum logic
		boolean[][] dp = new boolean[n][sum + 1];

		// tabulation
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}

		if (nums[0] <= sum) {
			dp[0][nums[0]] = true;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= sum; j++) {
				boolean notPick = dp[i - 1][j];
				boolean pick = false;
				if (nums[i] <= j) {
					pick = dp[i - 1][j - nums[i]];
				}
				dp[i][j] = pick || notPick;
			}
		}
		return dp[n-1][sum];
    }
}
