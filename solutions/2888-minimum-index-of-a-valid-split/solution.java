class Solution {
public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        int dominant = 0;
        int count = 0;
        for (Integer key : freq.keySet()) {
            if (freq.get(key) > n / 2) {
                dominant = key;
                count = freq.get(key);
                break;
            }
        }

        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            int leftSize = i + 1;
            int rightSize = n - leftSize;
            int rightCount = count - leftCount;

            if (leftCount > leftSize / 2 && rightCount > rightSize / 2) {
                return i;
            }
        }
        return -1;
    }
}
