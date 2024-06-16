class Solution {
    public void moveZeroes(int[] nums) {
        		int temp;
		int ptr1 = 0;
		for (int ptr2 = ptr1 + 1; ptr2 < nums.length; ptr2++) {
			if (nums[ptr1] != 0 && nums[ptr2] != 0) {
				ptr1++;
			} else if (nums[ptr1] == 0 && nums[ptr2] == 0) {
				continue;
			} else if (nums[ptr1] == 0 && nums[ptr2] != 0) {
				temp = nums[ptr1];
				nums[ptr1] = nums[ptr2];
				nums[ptr2] = temp;
				ptr1++;
			} else {
				ptr1++;
			}
		}
    }
}
