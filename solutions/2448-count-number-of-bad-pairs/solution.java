class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        long goodPair = 0;
        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            goodPair += freqMap.getOrDefault(key, 0);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }
        return (long) n * (n - 1) / 2 - goodPair;
    }
}
