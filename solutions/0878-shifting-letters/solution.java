class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int totalShift = 0;
        char[] schar = s.toCharArray();
        for (int i = schar.length - 1; i >= 0; i--) {
            totalShift += (shifts[i] % 26);
            schar[i] = (char) ((schar[i] - 'a' + totalShift) % 26 + 97);
        }
        return String.valueOf(schar);
    }
}
