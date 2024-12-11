class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < nums.length) {
            int currDiff = nums[right] - nums[left];

            while (currDiff > 2 * k) {
                left++;
                currDiff = nums[right] - nums[left];
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
