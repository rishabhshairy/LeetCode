class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
		int m = t.length();

		int[] freq = new int[256];

		if (n < m) {
			return "";
		}

		// step 1 store hash of t
		for (int i = 0; i < t.length(); i++) {
			freq[t.charAt(i)]++;
		}

		int left = 0;
		int right = 0;
		int count = 0;
		int startIndex = -1;
		int minLen = Integer.MAX_VALUE;

		while (right < n) {
			// check if curr char in S is there in freq
			if (freq[s.charAt(right)] > 0) {
				count++;
			}

			// main logic
			freq[s.charAt(right)]--;

			while (count == t.length()) {
				if (minLen > right - left + 1) {
					minLen = right - left + 1;
					startIndex = left; // found window start for answer
				}

				// increase hash as we move forward
				freq[s.charAt(left)]++;
				if (freq[s.charAt(left)] > 0) {
					count--;
				}
				left++;
			}

			right++;
		}
		return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
