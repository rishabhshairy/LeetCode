class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        long mini = Integer.MAX_VALUE;
        int negatives = 0;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] < 0) {
                    negatives++;
                }
                totalSum += Math.abs(matrix[i][j]);
                mini = Math.min(Math.abs(matrix[i][j]), mini);
            }
        }

        // now if negatives are Odd reduce sum by twice of mini
        if ((negatives & 1) == 1) {
            totalSum -= 2 * mini;
        }
        return totalSum;
    }
}
