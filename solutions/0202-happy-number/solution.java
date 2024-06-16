class Solution {
    public boolean isHappy(int n) {
        boolean isNumHappy = false;

        if (n == 1) {
            return true;
        }
        while (true) {
            int sum = getSum(n);
            if (sum / 10 == 0) {
                if (sum == 1 || sum == 7) {
                    isNumHappy = true;
                    break;
                } else {
                    isNumHappy=false;
                    break;
                }
            }
            n = sum;
        }
        return isNumHappy;

    }

    private int getSum(int num) {
        int sumOfSquares = 0;
        while (num != 0) {
            sumOfSquares += Math.pow(num % 10, 2);
            num = num / 10;
        }
        return sumOfSquares;
    }
}
