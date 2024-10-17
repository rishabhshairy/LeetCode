class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0, right = 0, sum = 0;
        int avg = 0, count = 0;

        while (right < arr.length) {
            sum += arr[right];
            int currWindow = right - left + 1;

            if (currWindow < k) {
                right++;
            } else if (currWindow == k) {
                avg = sum / k;
                if (avg >= threshold) {
                    count++;
                }
                sum -= arr[left];
                left++;
                right++;
            }

        }
        return count;
    }
}
