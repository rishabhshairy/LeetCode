class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        int maxLast = values[0];

        int maxi = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            maxi = Math.max(maxi, maxLast + values[i] - i);
            maxLast = Math.max(maxLast, values[i] + i);
        }
        return maxi;
    }
}
