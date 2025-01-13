class Solution {
    public int minimumLength(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        int[] freq = new int[26];
        for (Character ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int sum=0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] <= 2) {
                sum+=freq[i];
                continue;
            } else {
                if (freq[i] % 2 == 0) {
                    while (freq[i] > 2) {
                        freq[i]--;
                    }
                } else {
                    while (freq[i] > 1) {
                        freq[i]--;
                    }
                }
                sum+=freq[i];
            }
        }
        return sum;
    }
}
