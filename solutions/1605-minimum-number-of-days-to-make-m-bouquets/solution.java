class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int noOfFlowers = bloomDay.length;

        long requiredFlowers = (long) m * k;

        if (requiredFlowers > noOfFlowers) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }

        int low = minDay;
        int high = maxDay;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int counter = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                counter++;
            } else {
                bouquets += counter / k;
                counter = 0;
            }
        }
        bouquets += (counter / k);
        return bouquets >= m;
    }
}
