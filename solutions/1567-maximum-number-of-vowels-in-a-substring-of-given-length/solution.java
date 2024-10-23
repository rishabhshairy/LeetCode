class Solution {
    public int maxVowels(String s, int k) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        int maxCount = 0;

        int right = 0, count = 0;

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        maxCount = count;
        right = k;
        while (right < s.length()) {
            // reducing vowel count from left;
            if (vowels.contains(s.charAt(right - k))) {
                count--;

            }

            // increase current vowel count if found
            if (vowels.contains(s.charAt(right))) {
                count++;
            }
            right++;
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
