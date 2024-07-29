class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        // base case
        for (int j = 0; j < col; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < col) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            mini = Math.min(mini, dp[row - 1][i]);
        }
        return mini;
    }
}
