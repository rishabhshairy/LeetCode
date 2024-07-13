class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = findLowerBound(nums, target);
        if (first == n || nums[first] != target) {
            return new int[] { -1, -1 };
        }
        return new int[]{first, findUpperBound(nums,target)-1};
    }

    public static int findLowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int findUpperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
