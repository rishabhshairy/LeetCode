class Solution {
    public static int maximumCount(int[] nums) {
        int minPos = Integer.MAX_VALUE;
        int maxNeg = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                minPos = Math.min(minPos, nums[i]);
            } else if (nums[i] < 0) {
                maxNeg = Math.max(maxNeg, nums[i]);
            }
        }
//        System.out.println(minPos);
//        System.out.println(maxNeg);

        int totalPositive = nums.length - findLowerBound(nums, minPos);
        int totalNegative = findUpperBound(nums, maxNeg);

//        System.out.println(totalPositive);
//        System.out.println(totalNegative);
        return Math.max(totalNegative, totalPositive);
    }

    public static int findLowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // setting hypothetical answer if we don't find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int findUpperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // setting hypothetical answer if we dont find any such number

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
