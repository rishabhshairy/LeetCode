class Solution {
	/**
	 * DFS Approach
	 * 
	 * @param graph
	 * @return
	 */
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> result = new ArrayList<Integer>();
		int[] visited = new int[graph.length];

		// 3 states of nodes -- unknown, visited, safe

		for (int i = 0; i < graph.length; i++) {
			if (isSafe(i, graph, visited)) {
				result.add(i);
			}
		}
		return result;
	}

	private boolean isSafe(int node, int[][] graph, int[] visited) {

		// check if visited node is in previous path
		if (visited[node] == 2) {
			return true;
		}

		// check cylce
		if (visited[node] == 1) {
			return false;
		}

		visited[node] = 1;
		for (int adjnode : graph[node]) {
			if (!isSafe(adjnode, graph, visited)) {
				return false;
			}
		}

		// mark it safe
		visited[node] = 2;
		return true;
	}
}
