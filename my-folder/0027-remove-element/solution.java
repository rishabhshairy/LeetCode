class Solution {
    public int removeElement(int[] nums, int val) {
		int valCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				valCount++;
			}
		}

		int temp;
		int ptr1 = 0;
		for (int ptr2 = ptr1 + 1; ptr2 < nums.length; ptr2++) {
			if (nums[ptr1] != val && nums[ptr2] != val) {
				ptr1++;
			} else if (nums[ptr1] == val && nums[ptr2] == val) {
				continue;
			} else if (nums[ptr1] == val && nums[ptr2] != val) {
				temp = nums[ptr1];
				nums[ptr1] = nums[ptr2];
				nums[ptr2] = temp;
				ptr1++;
			} else {
				ptr1++;
			}
		}
		return nums.length - valCount;
    }
}
