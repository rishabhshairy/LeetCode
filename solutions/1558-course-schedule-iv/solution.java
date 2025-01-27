class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        List<List<Integer>> adjList = prepareGraph(numCourses, prerequisites);

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            result.add(isValid(u, v, adjList));

        }
        return result;
    }

    private Boolean isValid(int u, int v, List<List<Integer>> adjList) {
        int[] visited = new int[adjList.size()];
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.offer(u);

        while (!nodeQueue.isEmpty()) {
            Integer currNode = nodeQueue.poll();
            visited[currNode] = 1;

            if (currNode == v) {
                return true;
            }
            for (Integer adjNode : adjList.get(currNode)) {
                if (visited[adjNode] != 1) {
                    nodeQueue.offer(adjNode);
                }

            }
        }
        return false;
    }

    private List<List<Integer>> prepareGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] row : prerequisites) {
            adjList.get(row[0]).add(row[1]);
        }
        return adjList;
    }
}
