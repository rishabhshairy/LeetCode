class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = prepareGraph(n, edges);
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> vertices = new HashSet<>();
            if (visited[i] == -1) {
                dfs(i, adjList, visited, vertices);

                if (findEdges(adjList, vertices)) {
                    count++;
                }

            }
        }
        System.out.println(count);
        return count;
    }

    private void dfs(int currNode, List<List<Integer>> adjList, int[] visited, Set<Integer> vertices) {
        visited[currNode] = 1;
        vertices.add(currNode);
        for (int adjNode : adjList.get(currNode)) {
            if (visited[adjNode] == -1) {
                dfs(adjNode, adjList, visited, vertices);
            }
        }
    }

    private boolean findEdges(List<List<Integer>> adjList, Set<Integer> vertices) {
        int n = vertices.size();
        int edges = 0;
        for (int v : vertices) {
            edges += adjList.get(v).size();
        }
        int count = edges / 2;
        return count == n * (n - 1) / 2;
    }

    private List<List<Integer>> prepareGraph(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
