class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int num = 0;
        int prevNum = 0;
        if (s.length() == 1) {
            return charMap.get(s.charAt(0));
        }
        char[] allChars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = allChars[i];
            int currNum = charMap.get(ch);
            num += currNum >= prevNum ? currNum : -currNum;
            prevNum = currNum;
        }
        return num;
    }
}
