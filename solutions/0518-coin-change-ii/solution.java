class Solution {
    public int change(int value, int[] denominations) {
        int n = denominations.length;
        int[][] dp = new int[n + 1][value + 1];

        // base case
        for (int T = 0; T <= value; T++) {
            dp[0][T] = T % denominations[0] == 0 ? 1 : 0;
        }

        for (int index = 1; index < n; index++) {
            for (int val = 0; val <= value; val++) {
                int notPick = dp[index - 1][val];
                int pick = 0;
                if (denominations[index] <= val) {
                    pick = dp[index][val - denominations[index]];
                }
                dp[index][val] = notPick + pick;
            }
        }
        return dp[n - 1][value];
    }
}
