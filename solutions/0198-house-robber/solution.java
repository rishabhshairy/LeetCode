class Solution {
	public int rob(int[] nums) {
		int n = nums.length;
		int[] mem = new int[n];
		Arrays.fill(mem, -1);

		return solve(0, nums, mem);

	}

	private int solve(int i, int[] nums, int[] mem) {
		if (i >= nums.length) {
			return 0;
		}

		if (mem[i] != -1) {
			return mem[i];
		}

		int notPick = solve(i + 1, nums, mem);
		int pick = nums[i] + solve(i + 2, nums, mem);

		return mem[i] = Math.max(notPick, pick);
	}
}
