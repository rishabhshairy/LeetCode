class Solution {
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        Arrays.sort(bobSizes);
        int n = aliceSizes.length;
        int m = bobSizes.length;

        int aliceTotal = 0;
        int bobTotal = 0;
        for (int candy : aliceSizes) {
            aliceTotal += candy;
        }

        for (int candy : bobSizes) {
            bobTotal += candy;
        }
        for (int i = 0; i < n; i++) {
            int target = (bobTotal - aliceTotal + (2 * aliceSizes[i])) / 2;

            if (findTargetInBob(bobSizes, target)) {
                return new int[] { aliceSizes[i], target };
            }
        }
        return new int[0];
    }

    private static boolean findTargetInBob(int[] bobSizes, int target) {
        int low = 0;
        int high = bobSizes.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (bobSizes[mid] == target) {
                return true;
            } else if (bobSizes[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
