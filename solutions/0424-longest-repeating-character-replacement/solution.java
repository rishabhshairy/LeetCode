class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int[] hash = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;

        while (right < s.length()) {
            int charIndex = s.charAt(right) - 'A';
            hash[charIndex]++;
            maxFreq = Math.max(maxFreq, hash[charIndex]);

            // first checking negative condition to shrink the window
               if ((right - left + 1) - maxFreq > k){
                // shrink the window
                // reduce s[left] frequency
                int leftIndex = s.charAt(left) - 'A';
                hash[leftIndex]--;
                left++;
            }
            int currWindow = right - left + 1;
            int changes = currWindow - maxFreq;

            if (changes <= k) {
                maxLen = Math.max(maxLen, currWindow);
            }
            right++;
        }
        return maxLen;      
    }
}
