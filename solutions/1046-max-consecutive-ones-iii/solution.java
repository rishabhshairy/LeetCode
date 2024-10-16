class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, maxLen = 0;
        int zeros = 0, len = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            if (zeros <= k) {
                len = right - left + 1;
                maxLen = Math.max(len, maxLen);
            }

            if (zeros > k) {
                while (zeros > k) {
                    if (nums[left++] == 0) {
                        zeros--;
                    }
                }
            }

            right++;

        }
        return maxLen;
    }
}
