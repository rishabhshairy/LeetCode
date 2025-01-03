class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int result = 0;
        long runningSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            runningSum += nums[i];

            long remainingSum = sum - runningSum;

            if (runningSum >= remainingSum) {
                result++;
            }
        }
        return result;
    }
}
