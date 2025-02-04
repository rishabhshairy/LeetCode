class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {

		int[][] grid = triangle.stream()
				.map(x -> x.stream().mapToInt(i -> i).toArray())
				.toArray(int[][]::new);

		// Arrays.stream(grid).map(Arrays::toString).forEach(System.out::println);

		int rowCount = grid.length;

		int[][] dp = new int[rowCount][rowCount];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solve(0, 0, grid, dp);
	}

	private int solve(int row, int col, int[][] grid, int[][] dp) {
		if (row == grid.length) {
			return 0;
		}

		if (dp[row][col] != -1) {
			return dp[row][col];
		}

		// two path down or diagonal
		int down = grid[row][col] + solve(row + 1, col, grid, dp);
		int diag = grid[row][col] + solve(row + 1, col + 1, grid, dp);

		return dp[row][col] = Math.min(down, diag);
	}
}
