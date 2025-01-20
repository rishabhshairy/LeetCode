class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        		int[] freq = new int[26];
		int maxDuration = releaseTimes[0];
		char ans = keysPressed.charAt(0);
		for (int i = 1; i < keysPressed.length(); i++) {
			char ch = keysPressed.charAt(i);
			int duration = releaseTimes[i] - releaseTimes[i - 1];
			freq[ch - 'a'] = Math.max(freq[ch - 'a'], duration);

			if (maxDuration == freq[ch - 'a'] && ans <= ch) {
				maxDuration = freq[ch - 'a'];
				ans = ch;
			} else if (maxDuration < freq[ch - 'a']) {
				maxDuration = freq[ch - 'a'];
				ans = ch;
			}
		}
		return ans;
    }
}
