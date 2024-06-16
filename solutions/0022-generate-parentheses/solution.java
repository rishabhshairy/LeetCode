class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        int open = n;
        int close = n;
        String out = "";
        solve(open, close, out, answer);
        return answer;
    }

    private static void solve(int open, int close, String out, List<String> answer) {
        if (open == 0 && close == 0) {
            answer.add(out);
            return;
        }

        if (open != 0) {
            String op1 = out;
            op1 = op1 + "(";
            solve(open - 1, close, op1, answer);
        }
        if (close > open) {
            String op2 = out;
            op2 += ")";
            solve(open, close - 1, op2, answer);
        }
    }
}
