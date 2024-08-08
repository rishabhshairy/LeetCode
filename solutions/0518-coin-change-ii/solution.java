class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return countWaysRecMemo(n - 1, coins, amount, dp);
    }

        private static int countWaysRecMemo(int index, int[] denominations, int value, int[][] dp) {

        // base case
        if (index == 0) {
            if (value % denominations[index] == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[index][value] != -1) {
            return dp[index][value];
        }

        int notPick = countWaysRecMemo(index - 1, denominations, value, dp);
        int pick = 0;
        if (denominations[index]<=value){
            pick = countWaysRecMemo(index, denominations, value - denominations[index], dp);

        }

        return dp[index][value] = notPick + pick;
    }
}
