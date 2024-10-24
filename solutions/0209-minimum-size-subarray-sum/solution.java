class Solution {
    public int minSubArrayLen(int target, int[] nums) {
                int left = 0, right = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];
            
            // reduce window this sum breaches target
            while (sum >= target) {
                int window = right - left + 1;
                minLength = Math.min(minLength, window);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        // System.out.print(minLength);
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
