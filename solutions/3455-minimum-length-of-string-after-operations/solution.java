class Solution {
    public int minimumLength(String s) {
        if (s.length() <= 2) {
            return s.length();
        }

        Map<Character, Integer> charMap = new HashMap<>();

        for (Character c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        // System.out.println(charMap);
        int minLength = 0;
        for (Character currChar : charMap.keySet()) {
            int charCount = charMap.get(currChar);
            if (charCount > 2) {

                if (charCount % 2 == 0) {
                    minLength += (charCount - (charCount - 2));
                } else {
                    minLength += (charCount - (charCount - 1));
                }
            } else {
                minLength += charCount;
            }
        }
        return minLength;
    }
}
