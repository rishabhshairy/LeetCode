class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        long runningSum = 0;
        long maxi = 0;
        Set<Integer> numSet = new HashSet<>();

        while (right < nums.length) {

            // remove elements from set when window is hit
            int curr = nums[right];
            while (numSet.contains(curr) || (right - left + 1) > k && left < right) {
                runningSum -= nums[left];
                numSet.remove(nums[left]);
                left++;
            }

            // add elements to set
            runningSum += curr;
            numSet.add(curr);

            // when window is hit update maxi
            if (right - left + 1 == k) {
                maxi = Math.max(maxi, runningSum);
            }
            right++;
        }
        return maxi;
    }
}
