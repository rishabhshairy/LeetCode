class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (i <= 2) {
                dp[i] = i;
                continue;
            }
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - 1 - j]);
            }
        }
        return dp[n];
    }
}
