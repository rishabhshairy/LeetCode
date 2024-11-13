class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int lowerTarget = lower - nums[i];
            int highTarget = upper - nums[i];

            int lowerBound = findLowerUpper(nums, lowerTarget, i + 1, nums.length - 1, false);
            int upperBound = findLowerUpper(nums, highTarget, i + 1, nums.length - 1, true);

//            System.out.println(lowerBound);
//            System.out.println(upperBound);

            count += (upperBound - lowerBound);
        }
        return count;
    }

    private int findLowerUpper(int[] nums, int target, int left, int right, boolean findUpper) {
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // this will find lower bound
            if (!findUpper) {

                if (nums[mid] >= target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } // this will find upper bound
            else {

                if (nums[mid] > target) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
        }
        return left;
    }
}
