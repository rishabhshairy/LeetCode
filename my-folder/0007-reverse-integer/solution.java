class Solution {
    public int reverse(int x) {
        int revInt = 0;
        while (x != 0) {
            if (revInt > Integer.MAX_VALUE/10 || revInt < Integer.MIN_VALUE/10) {
                return 0;
            }
            revInt = revInt * 10 + (x % 10);
            x = x / 10;
        }
        return revInt;
    }
}
