class Solution {
    public int maxFrequency(int[] nums, int k) {
                Arrays.sort(nums);
        int left = 0;
        long prefixSum = 0;
        long target = 0;
        for (int right = 0; right < nums.length; right++) {
            target = nums[right];
            prefixSum += target;
            if (((long)((right - left + 1) * target) - prefixSum) > k) {
                System.out.println("right = " + right);
                prefixSum -= nums[left];
                left++;
            }
        }
        return nums.length - left;
    }
}
