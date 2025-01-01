class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] prefixSumOne = new int[n];
        int[] zeroCount = new int[n];
        // initialize zero count
        zeroCount[0] = s.charAt(0) == '0' ? 1 : 0;
        // initialize prefixSumCount
        prefixSumOne[n - 1] = s.charAt(n - 1) - '0';

        for (int i = n - 2; i > 0; i--) {
            prefixSumOne[i] = prefixSumOne[i + 1] + (s.charAt(i) - '0');

        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroCount[i] = zeroCount[i - 1] + 1;
            } else {
                zeroCount[i] = zeroCount[i - 1];
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int sum = zeroCount[i] + prefixSumOne[i + 1];
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
}
