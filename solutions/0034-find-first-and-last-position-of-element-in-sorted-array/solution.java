class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        int left = 0;
        int right = nums.length - 1;

        result[0] = lowerBound(left, right, nums, target);
        if (result[0] == nums.length || nums[result[0]] != target) {
            return new int[] { -1, -1 };
        }
        result[1] = upperBound(left, right, nums, target) - 1;
        return result;
    }

    private int upperBound(int left, int right, int[] nums, int target) {
        int ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int lowerBound(int left, int right, int[] nums, int target) {
       int ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
