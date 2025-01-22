class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();

		solve(1, n, k, result, curr);
		return result;
	}

	private void solve(int start, int n, int k, List<List<Integer>> result,
			List<Integer> curr) {

		if (k == 0) {
			result.add(new ArrayList<Integer>(curr));
			return;
		}

		for (int i = start; i <= n; i++) {
			curr.add(i);
			solve(i + 1, n, k - 1, result, curr);
			curr.remove(curr.size() - 1);

		}
	}
}
