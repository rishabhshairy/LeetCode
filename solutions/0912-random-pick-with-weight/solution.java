class Solution {

    int[] weightSum;
    Random random;
    int totalSum;

    public Solution(int[] w) {
        random = new Random();
        weightSum = new int[w.length];
        int running = 0;
        for (int i = 0; i < w.length; i++) {
            running += w[i];
            weightSum[i] = running;
        }
        this.totalSum = running;
    }

    public int pickIndex() {

        if (this.totalSum == 0) {
            return -1;
        }
        int next = this.random.nextInt(this.totalSum) + 1; // +1 for binary search is 0 is there in array
        // optimise using binary search
        int left = 0;
        int right = weightSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (weightSum[mid] == next) {
                return mid;
            }
            if (weightSum[mid] < next) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
