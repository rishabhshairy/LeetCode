class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOps = Integer.MAX_VALUE;
        int n = blocks.length();

        if (k == n) {
            int count = 0;
            for (char ch : blocks.toCharArray()) {
                if (ch == 'W') {
                    count++;
                }
            }
            return count;
        }

        for (int i = 0; i <= n - k; i++) {
            String s = blocks.substring(i, i + k);
            int count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == 'W') {
                    count++;
                }
            }
            minOps = Math.min(minOps, count);
        }

        return minOps;
    }
}
