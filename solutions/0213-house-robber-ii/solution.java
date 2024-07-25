class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int robFromLast = solveFromLast(nums, nums.length);
        int robFromSecondLast = solveFromSecondLast(nums, nums.length - 1);
        return Math.max(robFromLast, robFromSecondLast);
    }

    private static int solveFromSecondLast(int[] nums, int length) {
        int prev = nums[0]; // dp[0] or i-1
        int prev2 = 0; // neg or i-2

        for (int index = 1; index < length; index++) {
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

    private static int solveFromLast(int[] nums, int length) {
        int prev = nums[1]; // dp[0] or i-1
        int prev2 = 0; // neg or i-2

        for (int index = 2; index < length; index++) {
            int sumPick = nums[index];
            sumPick += prev2;
            int sumNonPick = prev;
            int currSum = Math.max(sumPick, sumNonPick);
            prev2 = prev;
            prev = currSum;
        }
        return prev;
    }
}
