class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        char[] strChar = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            strChar = rotate(strChar);
            if (new String(strChar).equals(goal)) {
                return true;
            }
        }
        return false;
    }

    private char[] rotate(char[] strChar) {
        char first = strChar[0];
        System.arraycopy(strChar, 1, strChar, 0, strChar.length - 1);
        strChar[strChar.length - 1] = first;
        return strChar;
    }
}
