class Solution {
    public int maxProfit(int[] values) {
        int n = values.length;
        long[][] dp = new long[n + 1][2];
        long profit = 0;

        // base case --> When we have no stock to buy/sell
        dp[n][0] = dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {

                if (canBuy == 0) {
                    long buy = -values[index] + dp[index + 1][1];
                    long notBuy = dp[index + 1][0];
                    profit = Math.max(buy, notBuy);
                }

                if (canBuy == 1) { // selling stocks
                    long sell = values[index] + dp[index + 1][0];
                    long notSell = dp[index + 1][1];
                    profit = Math.max(sell, notSell);
                }
                dp[index][canBuy] = profit;
            }
        }
        return (int)dp[0][0];
    }
}
