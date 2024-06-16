class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = Arrays.stream(nums).map(i -> i).sum();
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum == (totalSum)) {
                return i;
            }
             totalSum -= nums[i];
        }
        return -1;
    }
}
