class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n1 - 1, n2 - 1, s, t, dp);
    }

    private static int solve(int index1, int index2, String s, String t, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        // match case
        if (s.charAt(index1) == t.charAt(index2)) {
            return dp[index1][index2] = 1 + solve(index1 - 1, index2 - 1, s, t, dp);
        }
        // non Match case
        // move either index for 2 way possibilities
        return dp[index1][index2] = Math.max(solve(index1 - 1, index2, s, t, dp),
                solve(index1, index2 - 1, s, t, dp));
    }
}
