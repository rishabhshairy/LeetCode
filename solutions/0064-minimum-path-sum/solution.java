class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = grid[i][j];
                    if (i > 0) {
                        up += dp[i - 1][j];
                    } else {
                        up += (int) Math.pow(10, 9); // Adding very large values when index out of bounds
                    }

                    int left = grid[i][j];
                    if (j > 0) {
                        left += dp[i][j - 1];
                    } else {
                        left += (int) Math.pow(10, 9);
                    }

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
