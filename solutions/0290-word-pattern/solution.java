class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (!charToWord.containsKey(ch)) {
                charToWord.put(ch, word);
            }
            if (!wordToChar.containsKey(word)) {
                wordToChar.put(word, ch);
            }

            if (!(charToWord.get(ch).equals(word)) || !(wordToChar.get(word).equals(ch))) {
                return false;
            }
        }

        return true;
    }
}
