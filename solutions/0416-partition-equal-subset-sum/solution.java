class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 == 0) {
            int halfSum = totalSum / 2;
            return findSubsetSum(nums, n, halfSum);
        }
        return false;
    }

    private static boolean findSubsetSum(int[] arr, int n, int target) {
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int index = 1; index < n; index++) {
            for (int currTarget = 1; currTarget <= target; currTarget++) {
                boolean notPicked = dp[index - 1][currTarget];
                boolean picked = false;
                if (arr[index] <= currTarget) {
                    picked = dp[index - 1][currTarget - arr[index]];
                }
                dp[index][currTarget] = picked || notPicked;
            }
        }
        return dp[n - 1][target];
    }
}
