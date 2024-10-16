class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        int[] hash = new int[255];
        Arrays.fill(hash, -1);

        if (n == 0) {
            return 0;
        }

        while (right < n) {

            // already visited
            if (hash[s.charAt(right)] != -1) {
                // move left pointer one index ahead of repeating character's current position
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }
            len = right - left + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(right)] = right;
            right++;
        }

        return maxLen;
    }
}
