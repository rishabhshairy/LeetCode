class Solution {
	public int uniquePathsWithObstacles(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] mem = new int[m][n];
		for (int[] row : mem) {
			Arrays.fill(row, -1);
		}

		return solve(m - 1, n - 1, grid, mem);
	}

	private int solve(int row, int col, int[][] grid, int[][] mem) {
		// base case when obstacle is found
		if (row >= 0 && col >= 0 && grid[row][col] == 1) {
			return 0;
		}
		// when we reach 0,0 --> 1 way is found
		if (row==0 && col==0) {
			return 1;
		}
		if (row < 0 || col < 0) {
			return 0;
		}

		if (mem[row][col] != -1) {
			return mem[row][col];
		}

		int up = solve(row - 1, col, grid, mem);
		int left = solve(row, col - 1, grid, mem);

		return mem[row][col] = up + left;
	}
}
