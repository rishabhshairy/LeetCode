class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        int runSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runSum += nums[i];
        }
        return sum - runSum;
    }
}
