class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] asciiDiff = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            asciiDiff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0, right = 0, sum = 0;
        int maxLen = 0;

        while (right < asciiDiff.length) {
            sum += asciiDiff[right];

            while (sum > maxCost) {
                sum -= asciiDiff[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        // System.out.println(maxCost);
        return maxLen;
    }
}
