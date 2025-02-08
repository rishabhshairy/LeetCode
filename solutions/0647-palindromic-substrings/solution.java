class Solution {
	public int countSubstrings(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {

			int oddCount = solve(i, i, s);
			int evenCount = solve(i, i + 1, s);
			result += oddCount + evenCount;
		}
		return result;
	}

	private int solve(int left, int right, String s) {

		int count = 0;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
			count++;
		}

		return count;
	}
}
