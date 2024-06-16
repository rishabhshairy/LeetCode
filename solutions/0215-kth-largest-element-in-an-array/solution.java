class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int kIndex=nums.length-k;
        return nums[kIndex];
    }
}
