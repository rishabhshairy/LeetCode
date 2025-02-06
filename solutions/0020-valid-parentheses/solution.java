class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(')');
			} else if (ch == '{') {
				stack.push('}');
			} else if (ch == '[') {
				stack.push(']');
			} else {
				if (!stack.isEmpty() && stack.peek().equals(ch)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
}
