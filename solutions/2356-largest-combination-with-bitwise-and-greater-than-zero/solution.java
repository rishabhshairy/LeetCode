class Solution {
    public int largestCombination(int[] candidates) {
        int[] bits = new int[24];

        for (int i = 0; i < bits.length; i++) {
            for (int num : candidates) {
                // check if i-th bit is set in num
                if ((num & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < bits.length; i++) {
            max = Math.max(bits[i], max);
        }
        return max;
    }
}
