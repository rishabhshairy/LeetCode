class Solution {
    public int[] finalPrices(int[] prices) {
                Stack<Integer> pricesAfterDiscount = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            if (pricesAfterDiscount.isEmpty()) {
                answer[i] = prices[i];
            } else if (!pricesAfterDiscount.isEmpty() && prices[i] >= pricesAfterDiscount.peek()) {
                answer[i] = prices[i] - pricesAfterDiscount.peek();
            } else if (!pricesAfterDiscount.isEmpty() && prices[i] < pricesAfterDiscount.peek()) {
                while (!pricesAfterDiscount.isEmpty() && prices[i] < pricesAfterDiscount.peek()) {
                    pricesAfterDiscount.pop();
                }

                answer[i] = pricesAfterDiscount.isEmpty() ? prices[i] : prices[i] - pricesAfterDiscount.peek();
            }
            pricesAfterDiscount.push(prices[i]);

        }
        return answer;
    }
}
