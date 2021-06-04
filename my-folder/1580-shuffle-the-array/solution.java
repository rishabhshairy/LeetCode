class Solution {
    public int[] shuffle(int[] nums, int n) {
        int result[] = new int[nums.length];
        int j = n;
        int k = 0;
        for (int i = 0; i < n; i++) {
            result[k++] = nums[i];

            result[k++] = nums[j];
            j++;
        }
        return result;
    }
}
