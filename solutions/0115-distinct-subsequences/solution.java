class Solution {
    public int numDistinct(String str, String sub) {
        int n = str.length();
        int m = sub.length();
        int[][] dp = new int[n + 1][m + 1];
        int mod = (int) (1e9 + 7);
        // base case

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        // Copy Recurrence

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str.charAt(i - 1) == sub.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] % mod) + (dp[i - 1][j] % mod );
                } else {
                    dp[i][j] = dp[i - 1][j] % mod;
                }
            }
        }

        return dp[n][m];
    }
}
