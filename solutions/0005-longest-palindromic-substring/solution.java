class Solution {
    public String longestPalindrome(String s) {
        int maxLen = Integer.MIN_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // Odd Length
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                // window size > maxLen
                if (right - left + 1 > maxLen) {
                    res = s.substring(left, right + 1);
                    maxLen = right - left + 1;
                }
                left--;
                right++;
            }

            // Even Length
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                // window size > maxLen
                if (right - left + 1 > maxLen) {
                    res = s.substring(left, right + 1);
                    maxLen = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
