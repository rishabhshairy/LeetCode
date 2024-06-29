class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        // init variables
        char[] chars = s.toCharArray();
        int i = 0;
        int signMultiplier = 1;
        int answer = 0;

        // Check for sign multiplier
        if (chars[0] == '+') {
            i = 1;
        } else if (chars[0] == '-') {
            signMultiplier = -1;
            i = 1;
        }
        ;
        for (; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                break;
            }
            int n = chars[i] - '0';
            // check overflow
            if (answer > (Integer.MAX_VALUE - n) / 10) {
                return (signMultiplier == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            answer = answer * 10 + n;
        }
        answer *= signMultiplier;
        return answer;
    }
}
