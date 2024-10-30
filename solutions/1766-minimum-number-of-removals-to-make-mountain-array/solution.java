class Solution {
    public int minimumMountainRemovals(int[] nums) {

        int[] lis = findLIS(nums);
        int[] lds = findLDS(nums);

        // now calculate final result
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                res = Math.max(res, lis[i] + lds[i] - 1);
            }

        }
        return nums.length - res;
    }

    private int[] findLDS(int[] nums) {
        int n = nums.length;
        int[] curr = new int[n];
        Arrays.fill(curr, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    curr[i] = Math.max(curr[i], curr[j] + 1);
                }
            }
        }
        return curr;
    }

    private int[] findLIS(int[] nums) {
        // We will use tabulation to find LIS
        int n = nums.length;
        int[] curr = new int[n];
        Arrays.fill(curr, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    curr[i] = Math.max(curr[i], curr[j] + 1);
                }
            }
        }
        return curr;
    }
}
