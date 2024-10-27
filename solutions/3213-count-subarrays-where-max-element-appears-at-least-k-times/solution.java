class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int maxNum = Integer.MIN_VALUE;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == maxNum) {
                maxCount++;
            }

            while (maxCount >= k) {
                if (nums[left] == maxNum) {
                    maxCount--;
                }
                left++;
                // here we are subtracting array length - right because --> it will account for
                // both current
                // subarray and array till end
                count += nums.length - right;
            }
            right++;
        }
        return count;
    }
}
