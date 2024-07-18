class Solution {
    public static int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            totalSum += nums[i];
        }

        int low = max;
        int high = totalSum;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (checkSplit(nums, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int checkSplit(int[] nums, int num) {
        int currSplit = 1;
        int currMaxSum = 0;

        for (Integer currNum : nums) {
            if (currMaxSum + currNum <= num) {
                currMaxSum += currNum;
            } else {
                currSplit++;
                currMaxSum = currNum;
            }
        }
        return currSplit;
    }
}
