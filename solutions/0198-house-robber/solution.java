class Solution {
    public int rob(int[] nums) {
        int prev = nums[0]; // dp[0] or i-1
        int prev2 = 0;          // neg  or i-2

        for (int index = 1; index < nums.length; index++) {
            int sumPick = nums[index];
            if (index > 1) {
                sumPick += prev2;
            }
            int sumNonPick = prev;
            int currSum = Math.max(sumPick, sumNonPick);
            prev2 = prev;
            prev = currSum;
        }
        return prev;
    }
}
