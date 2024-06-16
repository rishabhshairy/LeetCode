class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> nums = new Stack<>();
        int temp = 0;
        char sign = '+';
        char[] exp = s.toCharArray();

        for (int i = 0; i < exp.length; i++) {
            char ch = exp[i];
            if (Character.isDigit(ch)) {
                temp = temp * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    nums.push(temp);
                } else if (sign == '-') {
                    nums.push(-temp);
                } else if (sign == '*') {
                    nums.push(nums.pop() * temp);
                } else if (sign == '/') {
                    nums.push(nums.pop() / temp);
                }

                sign = ch;
                temp = 0;
            }
        }
        int res = 0;
        while (!nums.isEmpty()) {
            res += nums.pop();
        }
        return res;
    }
}
