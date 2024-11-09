class Solution {
    public String largestOddNumber(String s) {
        int n = s.length();
        if ((int) s.charAt(n - 1) % 2 != 0) {
            return s;
        }

        int index = n - 1;
        while (index >= 0) {
            int lastDigit = s.charAt(index);
            if (lastDigit % 2 != 0) {
                return s.substring(0, index + 1);
            }
            index--;
        }
        return "";
    }
}
