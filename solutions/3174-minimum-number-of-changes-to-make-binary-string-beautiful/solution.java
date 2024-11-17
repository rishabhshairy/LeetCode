class Solution {
    public int minChanges(String s) {
        int minCount = 0;
        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                minCount++;
            }
        }
        return minCount;
    }
}