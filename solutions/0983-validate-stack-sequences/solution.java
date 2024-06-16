class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        Stack<Integer> pushStack = new Stack<>();

        for (Integer num :
                pushed) {
            pushStack.push(num);
            while (!pushStack.isEmpty() && popped[index] == pushStack.peek()) {
                pushStack.pop();
                index++;
            }
        }
        return pushStack.empty();
    }
}
