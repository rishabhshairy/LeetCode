class Solution {
    public int rob(int[] nums) {
                int n = nums.length;
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        dp[n]=0;
        dp[n+1]=0;

        for(int i=n-1;i>=0;i--) {
            int take = nums[i] + dp[i+2];
            int notTake = dp[i+1];
            dp[i] = Math.max(take,notTake);
        }

        return dp[0];
    }
}
