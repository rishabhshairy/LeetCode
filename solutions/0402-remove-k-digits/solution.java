class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> numStack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (k > 0 && !numStack.isEmpty() && ch < numStack.peek()) {
                k--;
                numStack.pop();
            }
            numStack.push(ch);
        }
        // now if still k is left, remove the digits from stack;
        while (k > 0) {
            k--;
            numStack.pop();
        }

        String result = numStack.stream().map(String::valueOf).collect(Collectors.joining());
        while (result.length() > 1 && result.charAt(0) == '0') {
            result=result.substring(1);
        }
        return result;
    }
}
