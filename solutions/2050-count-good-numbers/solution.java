class Solution {
    static long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPlaces = (n + 1) / 2;
        long oddPlaces = n / 2;

        int ans = (int) (((myPow(5, evenPlaces) % MOD) * (myPow(4, oddPlaces) % MOD)) % MOD);
        return ans;
    }

    public static long myPow(long x, long n) {
        long ans = 1L;

        long power = n;

        while (power > 0) {
            if (power % 2 == 0) {
                x = (x * x) % MOD;
                power = power / 2;
            } else {
                ans = (ans * x) % MOD;
                power = power - 1;
            }
        }
        return ans % MOD;
    }
}
