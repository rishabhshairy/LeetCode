class Solution {
    public boolean canJump(int[] nums) {
        int farthestJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthestJump) {
                return false;
            }
            farthestJump = Math.max(i + nums[i], farthestJump);
        }
        return true;
    }
}
