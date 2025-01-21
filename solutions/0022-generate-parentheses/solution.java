class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		solve(0, 0, n, "", result);
		return result;
	}

	private void solve(int left, int right, int n, String output,
			List<String> result) {

		if (output.length() == 2 * n) {
			result.add(output);
			return;
		}

		if (left < n) {
			solve(left + 1, right, n, output + "(", result);
		}
		if (right < left) {
			solve(left, right + 1, n, output + ")", result);
		}

	}
}
