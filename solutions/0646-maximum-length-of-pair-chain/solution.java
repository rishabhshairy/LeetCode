class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = pairs.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, -1, pairs, dp);
    }

    private int solve(int index, int prevIndex, int[][] pairs, int[][] dp) {

        if (index == pairs.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int notPick = solve(index + 1, prevIndex, pairs, dp);

        int pick = Integer.MIN_VALUE;
        if (prevIndex == -1 || pairs[prevIndex][1] < pairs[index][0]) {
            pick = 1 + solve(index + 1, index, pairs, dp);
        }
        return dp[index][prevIndex + 1] = Math.max(pick, notPick);
    }
}
