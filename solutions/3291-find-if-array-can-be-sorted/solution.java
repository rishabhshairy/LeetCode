class Solution {
    public boolean canSortArray(int[] nums) {
        int currMax = nums[0];
        int lastMax = 0;
        int currSetBits = countSetBits(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            boolean bitChange = currSetBits != countSetBits(nums[i]);

            if (bitChange) {
                lastMax = currMax;
            }

            if (nums[i] > currMax) {
                currMax = nums[i];
                currSetBits = countSetBits(currMax);
            }
            if (nums[i] < lastMax) {
                return false;
            }
        }
        return true;
    }

    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}
