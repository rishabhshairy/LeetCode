class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

    public int solve(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new LinkedHashMap<>();

        int left = 0, right = 0, count = 0;

        while (right < nums.length) {
            numsMap.put(nums[right], numsMap.getOrDefault(nums[right], 0) + 1);
            while (numsMap.size() > k) {
                numsMap.put(nums[left], numsMap.get(nums[left]) - 1);
                if (numsMap.get(nums[left]) == 0) {
                    numsMap.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
