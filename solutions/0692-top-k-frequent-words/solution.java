class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((w1, w2) -> {

            Integer w1Count = map.get(w1);
            Integer w2Count = map.get(w2);

            if (w1Count.equals(w2Count)) {
                return w2.compareTo(w1);
            }
            return w1Count - w2Count;
        });

        for (String word : map
                .keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        LinkedList<String> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll());
        }
        return result;
    }
}
