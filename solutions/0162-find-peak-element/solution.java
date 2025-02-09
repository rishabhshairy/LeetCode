class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

		// base cases
		if (nums.length == 1) {
			return 0;
		}

		if (nums[0] > nums[1]) {
			return 0;
		}

		if (nums[n - 1] > nums[n - 2]) {
			return n-1;
		}

		// if above conditions do not meet do BS on 1 - n-2
		int left = 1;
		int right = n - 2;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			// check direct mid
			if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
				return mid;
			}

			// redcue search space
			if (nums[mid] > nums[mid - 1]) { // 1 4 5 mid is 5
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
    }
}
