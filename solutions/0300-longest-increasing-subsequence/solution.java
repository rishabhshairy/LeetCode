class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];


        // form loops
        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

                int notTake = next[prevIndex + 1];
                int take = 0;

                if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
                    take = 1 + next[index + 1];

                }
                curr[prevIndex + 1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[0];
    }
}
