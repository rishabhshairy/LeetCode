class Solution {
	public int numDecodings(String s) {
		int[] mem = new int[s.length()];
		Arrays.fill(mem, -1);
		return solve(0, s, mem);
	}

	private int solve(int index, String s, int[] mem) {
		if (index == s.length()) {
			return 1;
		}
		if (s.charAt(index) == '0') {
			return 0;
		}
        if (mem[index]!=-1) {
			return mem[index];
		}
		int pick = solve(index + 1, s, mem);
		// most critical pair should be between 11 to 26
		if (index < s.length() - 1 && (s.charAt(index) == '1'
				|| s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
			pick += solve(index + 2, s, mem);
		}

		return mem[index] = pick;
	}
}
