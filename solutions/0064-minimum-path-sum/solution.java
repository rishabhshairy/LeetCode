class Solution {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] mem = new int[m][n];
		for (int[] row : mem) {
			Arrays.fill(row, -1);
		}
		
		return solve(m - 1, n - 1, grid, mem);
	}

	private int solve(int row, int col, int[][] grid, int[][] mem) {

		if (row==0 && col==0) {
			return grid[0][0];
		}

		if (row < 0 || col < 0) {
			return (int) Math.pow(10, 9);
		}

		if (mem[row][col] != -1) {
			return mem[row][col];
		}

		int up = grid[row][col] + solve(row - 1, col, grid, mem);
		int left = grid[row][col] + solve(row, col - 1, grid, mem);

		return mem[row][col] = Math.min(up, left);
	}
}
