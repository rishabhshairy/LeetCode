class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1); // reverse whole array
        reverse(nums,0,k-1);            // reverse first k elements
        reverse(nums,k,nums.length-1); // reverse last k elements
    }

    public void reverse (int[] arr, int i, int j) {
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
