class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return findIndex(nums, target, n);
    }
        public static int findIndex(int[] nums,int target, int n) {
        int low = 0;
        int high = n-1;
        int ans = -1;

        while (low <= high) {
            int mid = (low+high)/2;

            if (nums[mid] == target) {
                ans  = mid;
            }
            // left sorted
            if (nums[low] <= nums[mid]) {
                // check if element is between low and mid
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                
            } // right sorted
                else {
                    // check if target is between mid and high
                    if (nums[mid] <= target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
        }
        return ans;
    }
}
