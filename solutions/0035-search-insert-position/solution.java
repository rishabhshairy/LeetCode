class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = 0;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                pos = mid;
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
                pos = left;
            } else {
                left = mid + 1;
                pos = left;
            }
        }

        return pos;
    }
}
