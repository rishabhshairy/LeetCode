class Solution {
    public boolean canJump(int[] arr) {
       if (arr.length <= 1) {
            return true;
        }

        if (arr[0] == 0) {
            return false;
        }

        int max = arr[0];
        int remainingSteps = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return true;
            }

            max = Math.max(max, i + arr[i]);
            remainingSteps--;

            if (remainingSteps == 0) {
                jump++;

                if (i >= max) {
                    return false;
                }

                remainingSteps = max - i;
            }
        }

        return false; 
    }
}
