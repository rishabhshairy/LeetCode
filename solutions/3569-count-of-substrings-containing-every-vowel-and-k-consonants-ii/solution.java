class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeast(word, k) - atLeast(word, k + 1);
    }

    private long atLeast(String word, int k) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> map = new HashMap<>();
        int consonant = 0;
        int n = word.length();
        int left = 0;
        int right = 0;
        long res = 0;
        while (right < word.length()) {
            char curr = word.charAt(right);
            if (vowels.contains(curr)) {
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            } else {
                consonant++;
            }
            // sliding window condition
            while (map.keySet().size() == 5 && consonant >= k) {
                res += (n - right);
                char leftChar = word.charAt(left);
                if (vowels.contains(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                } else {
                    consonant--;
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
