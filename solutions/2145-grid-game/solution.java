class Solution {
    public long gridGame(int[][] grid) {
        long prefixSumRow1 = 0;
        long prefixSumRow2 = 0;
        long mini = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; i++) {
            prefixSumRow1 += grid[0][i];
        }

        for (int currCol = 0; currCol < grid[0].length; currCol++) {
            prefixSumRow1 -= grid[0][currCol];
            mini = Math.min(mini, Math.max(prefixSumRow1, prefixSumRow2));
            prefixSumRow2 += grid[1][currCol];
        }
        return mini;
    }
}
