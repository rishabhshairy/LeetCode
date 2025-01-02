class StockSpanner {
    Stack<int[]> stockPrices;

    public StockSpanner() {
        stockPrices = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stockPrices.isEmpty() && price >= stockPrices.peek()[0]) {
            span += stockPrices.peek()[1];
            stockPrices.pop();
        }
        stockPrices.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
