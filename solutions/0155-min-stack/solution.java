class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> st;

    public MinStack() {
        minStack = new Stack<>();
        st = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (st.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
