class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            final int currNode = queue.poll();
            if (end == currNode) {
                return true;
            }
            final Set<Integer> neighbours = find(edges, n, currNode);
            for (Integer node :
                    neighbours) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
        return false;
    }

    private Set<Integer> find(int[][] edges, int n, int currNode) {
        Set<Integer> neighbourSet = new HashSet<>();
        for (int[] edge :
                edges) {
            if (edge[0] == currNode) {
                neighbourSet.add(edge[1]);
            } else if (edge[1] == currNode) {
                neighbourSet.add(edge[0]);
            }
        }
        return neighbourSet;
    }
}
