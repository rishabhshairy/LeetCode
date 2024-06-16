class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] answer = new int[deck.length];
        Queue<Integer> deckIndexQueue = new LinkedList<>();
        Arrays.sort(deck);
        for (int i = 0; i < deck.length; i++) {
            deckIndexQueue.offer(i);
        }
        for (Integer num :
                deck) {
            answer[deckIndexQueue.poll()] = num;
            if (!deckIndexQueue.isEmpty()) {
                deckIndexQueue.offer(deckIndexQueue.poll());
            }
        }
        return answer;
    }
}
