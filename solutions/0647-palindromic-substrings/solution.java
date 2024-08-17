class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        // base case when length 1 of string is there
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        // base case for strings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans++;
            }
        }

        // now for length 3 and above
        for (int currLen = 3; currLen <= n; currLen++) {
            for (int left = 0; left < n - currLen + 1; left++) {
                int right = left + currLen - 1;
                // System.out.println(left + " " + right);
                // System.out.println(s.charAt(left) + " " + s.charAt(right));
                if (s.charAt(left) == s.charAt(right) && dp[left + 1][right - 1]) {
                    dp[left][right] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
