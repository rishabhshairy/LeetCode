class Solution {
    public int findPeakElement(int[] nums) {
                int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        // start binary search now
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Direct check if mid is peak
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // now do the elimination of search space
            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            } else {
                // this is extra check for multiple peak
                // we can go either left or right
                low = mid + 1;
            }

        }
        return -1;
    }
}
