class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }

        int oddFreqChar = 0;
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddFreqChar++;
            }
        }
        return oddFreqChar <= k;
    }
}
