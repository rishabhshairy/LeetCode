class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int target = sum - x;

        int minLength = 0;

        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }

        int left = 0, right = 0;
        while (right < nums.length) {

            target -= nums[right];
            right++;
            while (target < 0) {
                target += nums[left];
                left++;
            }

            if (target == 0) {
                minLength = Math.max(minLength, right - left);
            }

            
        }

        return minLength == 0 ? -1 : nums.length - minLength;
    }
}
