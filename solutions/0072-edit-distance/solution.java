class Solution {
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		int[][] mem = new int[n][m];
		for (int[] row : mem) {
			Arrays.fill(row, -1);
		}
		return solve(n - 1, m - 1, word1, word2, mem);
		
	}

	private int solve(int index1, int index2, String word1, String word2,
			int[][] mem) {

		if (index1 < 0) {
			return index2 + 1;
		}

		if (index2 < 0) {
			return index1 + 1;
		}

		if (mem[index1][index2] != -1) {
			return mem[index1][index2];
		}

		if (word1.charAt(index1) == word2.charAt(index2)) {
			return mem[index1][index2] = solve(index1 - 1, index2 - 1, word1,
					word2, mem);
		} else {
			// now we have 3 options
			int insert = 1 + solve(index1, index2 - 1, word1, word2, mem);
			int replace = 1 + solve(index1 - 1, index2 - 1, word1, word2, mem);
			int delete = 1 + solve(index1 - 1, index2, word1, word2, mem);
			return mem[index1][index2] = Math.min(insert,
					Math.min(replace, delete));
		}
	}
}
