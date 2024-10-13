class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 2];

        if (n <= 1) {
            return 1;
        }

        dp[0] = 1;
        dp[1] = 1;

        long res = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
