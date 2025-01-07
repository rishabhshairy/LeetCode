class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int maxArea = Integer.MIN_VALUE;

        while (index < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
                stack.push(index++);
            } else {
//                System.out.println(stack);
                int top = stack.pop();
                int currArea = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, currArea);
            }
        }

        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (stack.isEmpty() ? index : index - stack.peek() - 1));
        }
        return maxArea;
    }
}
