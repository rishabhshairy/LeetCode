class Solution {
    public int scoreOfParentheses(String s) {
                Stack<Integer> bracket = new Stack<>();
        bracket.push(0);

        for (Character ch :
                s.toCharArray()) {
            if (ch == '(') {
                bracket.push(0);
            } else {
                int v = bracket.pop();
                int w = bracket.pop();

                int depth = w + Math.max(2 * v, 1);
                bracket.push(depth);
            }
        }
        return bracket.pop();
    }
}
