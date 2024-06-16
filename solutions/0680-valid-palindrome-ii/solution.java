class Solution {
    public boolean validPalindrome(String s) {
        return solve(s, 0, s.length() - 1, false);
    }

    private boolean solve(String s, int left, int right, boolean used) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            if (!used) {
                if (solve(s, left + 1, right, true)) {
                    return true;
                }
                return solve(s, left, right - 1, true);
            } else {
                return false;
            }
        }
        return solve(s, left + 1, right - 1, used);
    }
}
