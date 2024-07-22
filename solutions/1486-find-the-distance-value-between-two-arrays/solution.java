class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            count++;
            int low = 0;
            int high = arr2.length - 1;

            int rangeFrom = arr1[i] - d;
            int rangeTo = arr1[i] + d;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (rangeFrom <= arr2[mid] && arr2[mid] <= rangeTo) {
                    count--;
                    break;
                } else if (arr2[mid] < rangeFrom) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return count;
    }
}
