class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0;

        while (right < s.length()) {
            char key = s.charAt(right);
            map.put(key, map.getOrDefault(key, 0) + 1);

            while (map.getOrDefault('a', 0) > 0
                    && map.getOrDefault('b', 0) > 0
                    && map.getOrDefault('c', 0) > 0) {
                count += s.length() - right;
                key = s.charAt(left);
                map.put(key, map.get(key) - 1);
                left++;

            }
            right++;
        }
        return count;
    }
}
