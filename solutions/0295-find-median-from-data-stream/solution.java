class MedianFinder {

        PriorityQueue<Long> minHeap; // storing 2nd half of numbers
        PriorityQueue<Long> maxHeap; // storing 1st half of numbers

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.add((long) num);
            minHeap.add(-maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(-minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() - minHeap.peek()) / 2.0;
            }
        }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
