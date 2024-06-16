class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (right > left) {
                left = right = 0;
            } else if (left == right) {
                count = Math.max(count, 2 * right);
            }
        }

        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left > right) {
                left = right = 0;
            } else if (left == right) {
                count = Math.max(count, 2 * left);
            }
        }
        return count;
    }
}
