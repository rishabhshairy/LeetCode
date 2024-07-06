class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int maxCount = Integer.MIN_VALUE;
        int currCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currCount++;
            } else if (arr[i] == 0) {
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            }
        }
        if (currCount > maxCount) {
            maxCount = currCount;
        }
        return maxCount;
    }
}
