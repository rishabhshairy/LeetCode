class Solution {
    public int jump(int[] nums) {
        if (nums.length<=1){
            return 0;
        }
        
        int jump = 1;
        int max = nums[0];
        int remainingSteps = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (i == nums.length - 1) {
                return jump;
            }
            max = Math.max(max, i + nums[i]);
            remainingSteps--;
            if (remainingSteps == 0) {
                jump++;

                if (i >= max) {
                    return -1;
                }

                remainingSteps = max - i;
            }
        }
        return jump;
    }
}
