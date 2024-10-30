class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        // using adjacency list to reverse the graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int v = graph.length;

        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int node : graph[i]) {
                adjacencyList.get(node).add(i);
            }
        }

        int[] inDegrees = new int[v];
        for (int i = 0; i < v; i++) {
            for (Integer node : adjacencyList.get(i)) {
                inDegrees[node]++;
            }
        }

        Queue<Integer> nodeQueue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegrees[i] == 0) {
                nodeQueue.offer(i);
            }
        }

        // Now do BFS
        while (!nodeQueue.isEmpty()) {
            Integer currNode = nodeQueue.poll();
            safeNodes.add(currNode);
            for (Integer adjNode : adjacencyList.get(currNode)) {
                inDegrees[adjNode]--;
                if (inDegrees[adjNode] == 0) {
                    nodeQueue.offer(adjNode);
                }
            }
        }
        Collections.sort(safeNodes);
        // System.out.println(safeNodes);
        return safeNodes;
    }
}
