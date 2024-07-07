class Solution {
    public static void nextPermutation(int[] nums) {

        // First find break point from back of array;
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // if index is -1 --> reverse the current array
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // Now swap the index position with smaller element from back of array
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        // now sort or reverse the array from index + 1 to end of array
        reverse(nums, index + 1, nums.length-1);

    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
