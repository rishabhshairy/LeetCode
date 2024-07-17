class Solution {
    public int shipWithinDays(int[] weights, int days) {
                int maxWeight = Integer.MIN_VALUE;
        int sumOfWeights = 0;

        for (int i = 0; i < weights.length; i++) {
            maxWeight = Math.max(maxWeight, weights[i]);
            sumOfWeights += weights[i];
        }

        int low = maxWeight;
        int high = sumOfWeights;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (findDays(weights, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
        private static int findDays(int[] weights, int currentWeightCapacity) {
        int days = 1; // first day
        int load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > currentWeightCapacity) {
                load = weights[i];
                days++;
            } else {
                load += weights[i];
            }
        }
        return days;
    }
}
