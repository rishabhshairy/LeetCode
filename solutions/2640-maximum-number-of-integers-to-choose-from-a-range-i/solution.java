class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        int maxCount = 0;
        boolean[] isBanNum = new boolean[10001];
        for (int num : banned) {
            isBanNum[num] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!isBanNum[i]){
                sum+=i;
                if (sum <= maxSum) {
                    maxCount++;
                }
            }
        }
        return maxCount;
    }
}
