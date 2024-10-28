class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Long> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add((long) nums[i]);
        }

        int maxLen = -1;

        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            while (numSet.contains((long) nums[i] * nums[i])) {
                nums[i] *= nums[i];
                len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
