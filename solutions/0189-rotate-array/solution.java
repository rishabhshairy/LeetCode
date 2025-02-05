class Solution {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
        k = k % n;
		reverse(0, n-1, nums);
		reverse(0,k-1,nums);
		reverse(k, n-1, nums);
	}

	private void reverse(int index, int n, int[] nums) {
		int left = index;
		int right = n;

		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}

	}
}
