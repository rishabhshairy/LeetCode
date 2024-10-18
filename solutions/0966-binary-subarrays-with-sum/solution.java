class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumHelper(nums, goal) - numSubarraysWithSumHelper(nums, goal - 1);
    }

    public int numSubarraysWithSumHelper(int[] nums, int goal) {
        int left = 0, right = 0, sum = 0, count = 0;
        if (goal < 0) {
            return 0;
        }
        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            // now count will be current window size
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}
