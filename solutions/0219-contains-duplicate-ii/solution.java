class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int index = 0; index < nums.length; index++) {

            // checking if num already in set
            if (numSet.contains(nums[index])) {
                return true;
            }

            // Adjust window size and remove first element from left
            if (index >= k) {
                int window = index - k;
                numSet.remove(nums[window]);
            }
            numSet.add(nums[index]);
        }
        
        return false;
    }
}
