class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> ngeMap = new LinkedHashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num2 : nums2) {
            while (!stack.isEmpty() && num2 > stack.peek()) {
                ngeMap.put(stack.pop(), num2);
            }
            stack.push(num2);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngeMap.getOrDefault(nums1[i], -1);
//            System.out.println(result[i]);
        }

        return result;
    }
}
