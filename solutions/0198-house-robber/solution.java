class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        Arrays.fill(dp, -1);
        dp[n] = 0;
        dp[n + 1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int prof1 = nums[i] + dp[i + 2];
            int prof2 = dp[i + 1];
            dp[i] = Math.max(prof1, prof2);
        }
        return dp[0];
    }

}
