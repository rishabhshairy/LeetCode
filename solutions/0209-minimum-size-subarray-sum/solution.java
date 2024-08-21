class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int end = 0, sum = 0, res = Integer.MAX_VALUE;

        for (int start = 0; start < nums.length; start++) {
            sum += nums[start];

            while (sum >= target) {
                res = Math.min(res, start - end + 1);
                sum -= nums[end++]; // reducing window size
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
