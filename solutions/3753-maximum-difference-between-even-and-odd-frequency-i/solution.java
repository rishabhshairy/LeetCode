class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

		for (char ch : s.toCharArray()) {
			freq[ch - 'a']++;
		}

		int maxOdd = Integer.MIN_VALUE;
		int minEven = Integer.MAX_VALUE;

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				if (freq[i] % 2 != 0) {
					maxOdd = Math.max(maxOdd, freq[i]);
				} else {
					minEven = Math.min(minEven, freq[i]);
				}
			}
		}
		return maxOdd - minEven;
    }
}
