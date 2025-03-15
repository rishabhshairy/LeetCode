class Solution {
    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (check(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int check(int[] nums, int mid) {
        int take = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                take++;
                i++;
            }
        }
        return take;
    }
}
