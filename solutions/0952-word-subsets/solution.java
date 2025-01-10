class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] word2Freq = new int[26];
        for (String word : words2) {
            int[] currFreq = new int[26];
            for (Character ch : word.toCharArray()) {
                currFreq[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                word2Freq[i] = Math.max(word2Freq[i], currFreq[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] currFreqWord1 = new int[26];
            boolean isUniversal = true;
            for (Character ch : word.toCharArray()) {
                currFreqWord1[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (currFreqWord1[i] < word2Freq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(word);
            }
        }
        return result;
    }
}
