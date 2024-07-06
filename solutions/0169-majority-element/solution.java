class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                element = nums[i];
            } else if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        // check if stored element is Majority in array

        int nextCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (element == nums[i]) {
                nextCount++;
            }
        }

        return (nextCount > nums.length / 2) ? element : -1;
    }
}
