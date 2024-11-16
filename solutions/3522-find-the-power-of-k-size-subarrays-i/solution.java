class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Arrays.fill(res, -1);

        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                count = 1;
            }

            // now check if we reach k with count
            if (count >= k) {
                res[i - k + 1] = nums[i];
            }
        }

        return res;
    }
}
