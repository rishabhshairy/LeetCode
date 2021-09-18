class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            }

            if (mid * mid > num) {
                right = (int) (mid - 1);
            } else {
                left = (int) (mid + 1);
            }
        }
        return false;
    }
}
