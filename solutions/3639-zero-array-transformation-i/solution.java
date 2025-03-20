class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n+1];
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]--;
            diff[r + 1]++;
        }
        int currDiff = 0;
        for (int i = 0; i < n; i++) {
            currDiff += diff[i];
            if (currDiff + nums[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
