class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
                int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = (up + left);
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
