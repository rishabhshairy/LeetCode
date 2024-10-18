class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

    private int solve(int[] nums, int k) {
        int left = 0, right = 0, count = 0, sum = 0;
        if (k < 0) {
            return 0;
        }
        while (right < nums.length) {

            sum += nums[right] % 2;

            // using another while loop we shrink the window
            while (sum > k) {
                sum -= nums[left] % 2;
                left++;
            }
            count += (right - left + 1); // window size will be added to count
            right++;
        }

        return count;
    }
}
