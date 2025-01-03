class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> handQueue = new PriorityQueue<>((a, b) -> (a - b));
        for (int card : hand) {
            handQueue.add(card);
        }

        while (!handQueue.isEmpty()) {
            int top = handQueue.poll();
            for (int i = 1; i < groupSize; i++) {
                if (!handQueue.remove(top + i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
