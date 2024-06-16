class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> heapQueue = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        for (Integer key : freqMap.keySet()) {
            heapQueue.add(key);
        }
        for (int i = 0; i < k; i++) {
            answer[i] = heapQueue.poll();
        }
        return answer;
    }
}
