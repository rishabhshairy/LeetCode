class Solution {
	public int lengthOfLIS(int[] nums) {

		// take dp of length n
		int n = nums.length;
		int[][] dp = new int[n][n + 1];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solve(0, -1, nums, dp);

	}

	private int solve(int index, int prevIndex, int[] nums, int[][] dp) {

		if (index == nums.length) {
			return 0;
		}

		if (dp[index][prevIndex + 1] != -1) {
			return dp[index][prevIndex + 1];
		}

		int notTake = solve(index + 1, prevIndex, nums, dp);

		int take = 0;

		// we can only take if next number is greater than previous number
		if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
			take = 1 + solve(index + 1, index, nums, dp); // move to next index
															// and mark prev =
															// index
		}

		return dp[index][prevIndex + 1] = Math.max(notTake, take);

	}
}
