class Solution {
    public boolean isMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // base case
        dp[0][0] = true;

        // when pattern is exhausted
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }

        // when text is exhausted but pattern is still left
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = isAllStarTable(pattern, j);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {

                    if (pattern.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[n][m];
    }
        private static boolean isAllStarTable(String pattern, int j) {
        for (int index = 1; index <= j; index++) {
            if (pattern.charAt(index - 1) != '*') {
                return false;
            }
        }
        return true;
    }
}
