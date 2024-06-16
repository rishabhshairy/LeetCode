class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
		int maxEnd = 0;

		for (int i : nums) {
			maxEnd += i;

			if (maxSoFar < maxEnd) {
				maxSoFar = maxEnd;
			}
			if (maxEnd < 0) {
				maxEnd = 0;
			}
		}
		return maxSoFar;
    }
}
