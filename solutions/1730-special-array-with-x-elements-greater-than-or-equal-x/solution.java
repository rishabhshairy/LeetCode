class Solution {
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int rangeVal = 1; rangeVal <= nums.length; rangeVal++) {
            int lowerBoundIndex = findLowerBound(nums, rangeVal);
            if (nums.length - lowerBoundIndex == rangeVal) {
                return rangeVal;
            }
        }
        return -1;
    }

    private static int findLowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length; // assuming max element will be the least index value

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
