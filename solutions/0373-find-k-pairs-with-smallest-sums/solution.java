class Solution {
    static class SumIndex {
        int sum;
        int index;

        public SumIndex(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<SumIndex> minHeap = new PriorityQueue<>((x, y) -> x.sum - y.sum);

        // first push all pair with num2[0]
        for (int x : nums1) {
            minHeap.offer(new SumIndex(x + nums2[0], 0));
        }

        // now poll and form pair with other nums of num2
        while (k > 0 & !minHeap.isEmpty()) {
            SumIndex curr = minHeap.poll();
            int sum = curr.sum;
            int index = curr.index;

            List<Integer> currPair = new ArrayList<>();
            currPair.add(sum - nums2[index]);
            currPair.add(nums2[index]);
            result.add(currPair);

            // for more elements push again
            if (index + 1 < nums2.length) {
                minHeap.offer(new SumIndex(sum - nums2[index] + nums2[index + 1], index + 1));
            }
            k--;
        }
        return result;
    }
}
