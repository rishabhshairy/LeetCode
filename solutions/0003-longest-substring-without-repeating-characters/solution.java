class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
		int right = 0;

		int[] position = new int[255];
		Arrays.fill(position, -1);
		int maxLen = Integer.MIN_VALUE;

		while (right < s.length()) {

			if (position[s.charAt(right)] != -1) {
				if (position[s.charAt(right)] >= left) {
					left = position[s.charAt(right)] + 1; // move left one index
															// ahead of repeated
															// character
				}
			}
			maxLen = Math.max(maxLen, right - left + 1);
			position[s.charAt(right)] = right;
			right++;
		}
		
		return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
