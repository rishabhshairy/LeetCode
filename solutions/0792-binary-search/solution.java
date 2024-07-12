class Solution {
    public int search(int[] arr, int target) {
        return solve(arr, 0, arr.length - 1, target);
    }
        private static int solve(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return solve(arr, mid + 1, high, target);
        } else {
            return solve(arr, low, mid - 1, target);
        }
    }
}
