class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        long[][] dp = new long[n][n];
        int mod = 1_000_000_007;

        for (int start = n - 1; start >= 0; start--) {
            dp[start][start] = 1;
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 * dp[start + 1][end - 1];
                    int left = start + 1;
                    int right = end - 1;
                    while (left <= right && s.charAt(left) != s.charAt(start)) {
                        left++;
                    }

                    while (left <= right && s.charAt(right) != s.charAt(end)) {
                        right--;
                    }

                    if (left > right) {
                        dp[start][end] += 2;
                    } else if (left == right) {
                        dp[start][end] += 1;
                    } else {
                        dp[start][end] -= dp[left + 1][right - 1];
                    }

                } else {
                    dp[start][end] = dp[start + 1][end] + dp[start][end - 1] - dp[start + 1][end - 1];
                }
                dp[start][end] = (dp[start][end] + mod) % mod;
            }
        }
        
        return (int) dp[0][n-1];
    }
}
