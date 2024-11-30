class Solution {
    public int[][] validArrangement(int[][] pairs) {

        // Step 1 --> Create Graph using map
        HashMap<Integer, Deque<Integer>> adjacencyMatrix = new HashMap<>();

        // Create in-degree and out degree maps
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];

            adjacencyMatrix.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        // find starting node , where out > in
        int startNode = -1;

        for (int key : outDegree.keySet()) {
            if (outDegree.get(key) == inDegree.getOrDefault(key, 0) + 1) {
                startNode = key;
                break;
            }
        }

        if (startNode == -1) {
            startNode = pairs[0][0];
        }

        List<Integer> result = new ArrayList<>();

        // do DFS Traversal
        visit(startNode, adjacencyMatrix, result);

        // since the result will be in reverse order
        Collections.reverse(result);
//        System.out.println(result);
        int[][] answer = new int[result.size() - 1][2];
        for (int i = 1; i < result.size(); i++) {
            answer[i - 1] = new int[]{result.get(i - 1), result.get(i)};
        }
        return answer;
    }

    private void visit(int startNode, HashMap<Integer, Deque<Integer>> adjacencyMatrix, List<Integer> result) {
        Deque<Integer> neighbors = adjacencyMatrix.get(startNode);
        while (neighbors != null && !neighbors.isEmpty()) {
            int adjNode = neighbors.pollFirst();
            visit(adjNode, adjacencyMatrix, result);
        }
        result.add(startNode);
    }
}
