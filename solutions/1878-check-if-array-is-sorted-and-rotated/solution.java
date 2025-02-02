class Solution {
    public boolean check(int[] nums) {
        int gteCount = 0;
        int n =  nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] > nums[(i+1) % n]) {
                gteCount++;
            }
        }

        if(gteCount > 1){
            return false;
        }
        return true;
    }
}
