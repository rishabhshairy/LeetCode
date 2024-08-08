class Solution {
    public int coinChange(int[] num, int target) {
        // Step 1 --> declare DP array
        int n = num.length;
        int[][] dp = new int[n][target + 1];

        // Step 2 --> base condition
        // why looping from 0 --> target == dp[0][target] needs to be checked for each
        // a[0]
        for (int i = 0; i <= target; i++) {
            if (i % num[0] == 0) {
                dp[0][i] = i / num[0];
            } else {
                dp[0][i] = (int) Math.pow(10, 9);
            }
        }
        // Step 3 --> form loops
        for (int index = 1; index < n; index++) {
            for (int currTarget = 0; currTarget <= target; currTarget++) {
                int notPick = dp[index - 1][currTarget];
                int pick = (int) Math.pow(10, 9);
                if (num[index] <= currTarget) {
                    pick = 1 + dp[index][currTarget - num[index]];
                }
                dp[index][currTarget] = Math.min(notPick, pick);
            }
        }

        return dp[n - 1][target] != (int) Math.pow(10,9) ? dp[n - 1][target] : -1;
    }
}
