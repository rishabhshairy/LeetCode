class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int[] results = prices.clone();

        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                results[st.pop()] -= prices[i];
            }
            st.push(i);
        }
        return results;
    }
}
