class Solution {
    public void moveZeroes(int[] nums) {
        int zeros = 0;
        int p2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                nums[p2++] = nums[i];
            }
        }
        // fill zeros at end
        for (int i = 0; i < zeros; i++) {
            nums[p2++] = 0;
        }
    }
}
