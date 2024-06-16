class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> numStack = new Stack<>();
        int total = 0, mod = (int) (1e9 + 7);
        int[] dp = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!numStack.isEmpty() && A[numStack.peek()] > A[i]) {
                numStack.pop();
            }
            if (numStack.isEmpty()) {
                dp[i] = (i + 1) * A[i];
            } else {
                dp[i] = dp[numStack.peek()] + (i - numStack.peek()) * A[i];
            }
            total = (total + dp[i]) % mod;
            numStack.push(i);
        }
        return total;
    }
}
