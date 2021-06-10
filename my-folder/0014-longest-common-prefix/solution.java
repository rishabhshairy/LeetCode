class Solution {
    public String longestCommonPrefix(String[] strs) {
                Arrays.sort(strs);
        String smallest = strs[0];
        String largest = strs[strs.length - 1];
        int maxLength = 0;
        for (int i = 0; i < smallest.length(); i++) {
            if (smallest.charAt(i) == largest.charAt(i)) {
                maxLength++;
            } else {
                break;
            }
        }

        return maxLength == 0 ? "" : largest.substring(0, maxLength);
    }
}
