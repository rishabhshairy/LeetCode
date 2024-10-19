class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();

        int left = 0, right = 0;

        while (right < arr.length) {
            // push max element into queue
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < arr[right]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(arr[right]);

            // when we hit window
            if (right - left + 1 == k) {
                result.add(maxQueue.peekFirst());
                if (maxQueue.peekFirst() == arr[left]) {
                    maxQueue.pollFirst();
                }
                left++;
                right++;
            }

            if (right - left + 1 < k) {
                right++;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
