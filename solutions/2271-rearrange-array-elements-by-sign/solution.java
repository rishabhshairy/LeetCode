class Solution {
    public int[] rearrangeArray(int[] nums) {
        int halfLen = nums.length / 2;
        int[] positive = new int[halfLen];
        int[] negative = new int[halfLen];
        int[] result = new int[nums.length];

        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) {
                positive[i++] = nums[k];
            } else {
                negative[j++] = nums[k];
            }
        }
        i = 0;
        j = 0;

        for (int k = 0; k < result.length; k++) {
            if (k % 2 == 0) {
                result[k] = positive[i++];
            } else {
                result[k] = negative[j++];
            }
        }

        return result;
    }
}
