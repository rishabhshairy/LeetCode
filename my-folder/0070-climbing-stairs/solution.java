class Solution {
    public int climbStairs(int n) {
                if (n == 0) {
            return 1;
        } else {
            int[] stepsTaken = new int[n+1];
            stepsTaken[0] = 1;
            stepsTaken[1] = 1;

            for (int i = 2; i <n+1; i++) {
                stepsTaken[i] = stepsTaken[i - 1] + stepsTaken[i - 2];
            }
            return stepsTaken[n];
        }
    }
}
