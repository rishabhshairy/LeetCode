class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjacencyMatrix = prepareGraph(n, edges);

        // apply Floyd warshall now
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjacencyMatrix[i][via] != 1e9 && adjacencyMatrix[via][i] != 1e9) {
                        adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j],
                                adjacencyMatrix[i][via] + adjacencyMatrix[via][j]);
                    }
                }
            }
        }

        // put -1 for non reachable path
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1e9) {
                    adjacencyMatrix[i][j] = -1;
                }
            }
        }

        Map<Integer, Integer> cityMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] <= distanceThreshold) {
                    cityMap.put(i, cityMap.getOrDefault(i, 0) + 1);
                }
            }

        }

        int result = Integer.MAX_VALUE;
        int minCity = Integer.MAX_VALUE;
        for (Integer city : cityMap.keySet()) {

            if (minCity >= cityMap.get(city)) {
                minCity = cityMap.get(city);
                result = city;
            }
        }
        return result;
    }

    private int[][] prepareGraph(int n, int[][] edges) {
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    mat[i][j] = (int) 1e9;
                }
            }
        }

        // insert into graph
        for (int i = 0; i < edges.length; i++) {
            int row = edges[i][0];
            int col = edges[i][1];
            int weight = edges[i][2];

            mat[row][col] = weight;
            mat[col][row] = weight;
        }

        return mat;
    }
}
