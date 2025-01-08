class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                count += isPrefixAndSuffix(words[i], words[j]) ? 1 : 0;
            }
        }

        return count;
    }

    private static boolean isPrefixAndSuffix(String str, String word) {

        return word.startsWith(str) && word.endsWith(str);
    }
}
