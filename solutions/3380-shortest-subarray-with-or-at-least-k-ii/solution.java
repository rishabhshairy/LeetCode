class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] bitCount = new int[32];

        while (right < nums.length) {
            updateBitCount(bitCount, nums[right], 1);
            while (left <= right && convertBitToNums(bitCount) >= k) {
                minLen = Math.min(minLen, right - left + 1);

                // remove the left position from window
                updateBitCount(bitCount, nums[left], -1);
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    private int convertBitToNums(int[] bitCount) {
        int result = 0;
        for (int i = 0; i < bitCount.length; i++) {
            if (bitCount[i] != 0) {
                result |= (1 << i);
            }
        }
//        System.out.println(result);
        return result;
    }

    /**
     * @param bitCount
     * @param num
     * @param delta    -- being used to increase and decrease the count
     */
    private void updateBitCount(int[] bitCount, int num, int delta) {
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bitCount[i] += delta;
            }
        }
    }
}
