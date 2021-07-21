class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
                int[] answer = new int[temperatures.length];
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!temp.isEmpty() && temperatures[temp.peek()] < temperatures[i]) {
                int index = temp.pop();
                answer[index] = i - index;
            }
            temp.push(i);
        }
        return answer;
    }
}
