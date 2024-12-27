class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int index = 2 * n - 1; index >= 0; index--) {

            int modIndex = index % n;
            if (stack.isEmpty()) {
                result[modIndex] = -1;
            } else if (!stack.isEmpty() && nums[modIndex] < stack.peek()) {
                result[modIndex] = stack.peek();
            } else {
                while (!stack.isEmpty() && nums[modIndex] >= stack.peek()) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result[modIndex] = -1;
                } else {
                    result[modIndex] = stack.peek();
                }
            }
            stack.push(nums[modIndex]);
        }
        return result;
    }
}
