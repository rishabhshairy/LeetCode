class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = Integer.MAX_VALUE;

        // memoize
        int[][] dp = new int[row + 1][col + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        for (int j = 0; j < col; j++) {
            ans = Math.min(ans, solve(0, j, row, col, grid, moveCost, dp));
        }

        return ans;
    }

    private static int solve(int currRow, int currCol, int row, int col, int[][] grid, int[][] moveCost, int[][] dp) {

        if (currRow == row - 1) {
            return grid[currRow][currCol];
        }

        if (dp[currRow][currCol] != -1) {
            return dp[currRow][currCol];
        }

        int totalCost = Integer.MAX_VALUE;

        // Again move from column 0 --> col-1

        for (int j = 0; j < col; j++) {
            int pathCost = grid[currRow][currCol];
            int currMoveCost = moveCost[pathCost][j];
            totalCost = Math.min(totalCost,
                    solve(currRow + 1, j, row, col, grid, moveCost, dp) + pathCost + currMoveCost);
        }

        return dp[currRow][currCol] = totalCost;
    }
}
