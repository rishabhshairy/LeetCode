class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if (nums.length > threshold) {
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // Now apply binary search
        int low = 1;
        int high = max;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isDivisorSumLess(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isDivisorSumLess(int[] nums, int mid, int threshold) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double) nums[i] / (double) mid);
        }
        return sum <= threshold;
    }
}
