class Solution {
    public int[] productExceptSelf(int[] nums) {
                int prod = 1;
        int zeros = 0;
        for (int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                zeros++;
            }
        }

        if (zeros > 1) {
            return new int[nums.length];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeros > 0) {
                result[i] = (nums[i] == 0) ? prod : 0;
            } else {
                result[i] = prod / nums[i];
            }
        }
        return result;
    }
}
