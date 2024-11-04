class Solution {
    public int jump(int[] nums) {
                int n = nums.length;
        int jump = 0, left = 0, right = 0;
        while (right < n - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jump++;
        }
        return jump;
    }
}
