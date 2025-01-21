class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int left = 0;
		int right = 0;
		int maxLen = Integer.MIN_VALUE;

		int[] charPos = new int[255];
		Arrays.fill(charPos, -1);

		while (right < s.length()) {

			// critical section -- if char is found previously
			if (charPos[s.charAt(right)] != -1) {
				// move char ahead one postion of current repeating
                if(charPos[s.charAt(right)] >= left) {
                    left = charPos[s.charAt(right)] + 1;
                }
				
			}

			int len = right - left + 1;
			maxLen = Math.max(maxLen, len);
			charPos[s.charAt(right)] = right; // marking index of each position
			right++;

		}
		return maxLen;
    }
}
