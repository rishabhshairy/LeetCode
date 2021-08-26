class Solution {
    HashMap<String, Boolean> wordMap = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        if (wordMap.containsKey(s) && !wordMap.get(s)) {
            return false;
        }

        for (String word :
                wordDict) {
            int len = word.length();
            if (s.indexOf(word) == 0) {
                if (wordBreak(s.substring(len), wordDict)) {
                    return true;
                }
            }
        }
        wordMap.put(s, false);
        return false;
    }
}
