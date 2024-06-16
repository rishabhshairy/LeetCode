class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return;
        }
        // while (k-- > 0) {
        //     int temp = nums[n - 1];
        //     for (int i = n - 1; i > 0; i--) {
        //         nums[i] = nums[i - 1];
        //     }
        //     nums[0]=temp;
        // }
        
            k = k % n;
            reverse(nums, 0, n - k - 1);
            reverse(nums, n - k, n - 1);
            reverse(nums, 0, n - 1);
    }
    static void reverse(int arr[], int i, int j) {
        int temp = 0;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
