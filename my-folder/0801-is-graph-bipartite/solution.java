class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!checkDFS(graph, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDFS(int[][] graph, int[] color, int node) {
        if (color[node] == -1) {
            color[node] = 1;

        }
        
        for (Integer adjNode :
                graph[node]) {
            if (color[adjNode] == -1) {
                color[adjNode] = color[node] ^ 1;
                if (!checkDFS(graph, color, adjNode)) {
                    return false;
                }

            } else if (color[adjNode] == color[node]) {
                return false;
            }
        }
        return true;
    }

}
