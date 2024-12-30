class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;

        for (int index = 0; index <= high; index++) {
            if (index + zero <= high) {
                dp[index + zero] = (dp[index + zero] + dp[index]) % mod;
            }
            if (index + one <= high) {
                dp[index + one] = (dp[index + one] + dp[index]) % mod;
            }
        }

        // now count between low to high
        for (int index = low; index <= high; index++) {
            ans = (ans+ dp[index]) % mod;
        }
        return ans%mod;
    }
}
