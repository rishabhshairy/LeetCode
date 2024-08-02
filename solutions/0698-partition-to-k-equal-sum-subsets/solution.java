class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % k == 0) {
            int[] visited = new int[nums.length];
            int halfSum = totalSum / k;
            return findSubsetSum(nums, k, 0, 0, 0, halfSum, visited);
        }
        return false;
    }

    private static boolean findSubsetSum(int[] nums, int k, int numCompleted, int currentSum, int index, int target,
            int[] visited) {

        // Return true if we have successfully formed k-1 subsets
        // as the last subset will for sure can be formed
        if (numCompleted == k) {
            return true;
        }

        if (currentSum > target) {
            return false;
        }

        // When successfully formed one subset find another subset from index 0
        if (currentSum == target) {
            return findSubsetSum(nums, k, numCompleted + 1, 0, 0, target, visited);
        }

        // Try out each possibility to group into each subset
        for (int i = index; i < nums.length; i++) {
            // try nums[i] if not visited
            if (visited[i] == 0) {
                visited[i] = 1;
                //currentSum += nums[i];
                // We only need to try out i+1, i+2 elements and onwards
                // as the previous elements have already been tried out in previous backtrack
                // loops
                if (findSubsetSum(nums, k, numCompleted, currentSum + nums[i], i + 1, target, visited)) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }
}
