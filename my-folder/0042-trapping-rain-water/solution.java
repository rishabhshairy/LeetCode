class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int trappedWater = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = max;
        }

        // Calculating water
        for (int i = 0; i < n; i++) {
            int a = left[i];
            int b = right[i];
            trappedWater += Math.min(a, b) - arr[i];
        }

        return trappedWater;
    }
}
