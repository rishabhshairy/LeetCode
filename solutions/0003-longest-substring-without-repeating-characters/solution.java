class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        HashSet<Character> longCharacters = new HashSet<>();
        while (j < s.length()) {
            if (!longCharacters.contains(s.charAt(j))) {
                longCharacters.add(s.charAt(j++));
                max = Math.max(max, longCharacters.size());
            } else {
                longCharacters.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
