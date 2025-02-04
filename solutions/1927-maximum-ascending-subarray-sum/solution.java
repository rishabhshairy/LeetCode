class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];  // Initialize with the first element
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i]; // Extend current ascending subarray
            } else {
                maxSum = Math.max(maxSum, sum); // Store max sum
                sum = nums[i]; // Reset sum for new subarray
            }
        }
        return Math.max(maxSum, sum); // Ensure the last segment is considered
    }
}

