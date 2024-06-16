class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxProd;
            maxProd = Math.max(Math.max(nums[i] * maxProd, nums[i] * minProd), nums[i]);
            minProd = Math.min(Math.min(temp * nums[i], minProd * nums[i]), nums[i]);

            if (result < maxProd) {
                result = maxProd;
            }
        }

        return result;
    }
}
