class Solution {
    static class Pair {
        int first;
        int second;

        public Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    public int numIslands(char[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col] = true;
        Queue<Pair> vertexQueue = new LinkedList<>();
        vertexQueue.offer(new Pair(row, col));
        int rowSize = grid.length;
        int colSize = grid[0].length;

        while (!vertexQueue.isEmpty()) {
            int currRow = vertexQueue.peek().first;
            int currCol = vertexQueue.peek().second;
            vertexQueue.poll();

            // traverse neighbours and mark them visited

            for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
                for (int deltaCol = -1; deltaCol <= 1; deltaCol++) {
                    int nrow = deltaRow + currRow;
                    int ncol = deltaCol + currCol;

                    if ((deltaRow == -1 && deltaCol == -1) || (deltaRow == -1 && deltaCol == 1)
                            || (deltaRow == 1 && deltaCol == -1) || (deltaRow == 1 && deltaCol == 1)) {
                        continue;
                    }

                    // boundary condition check
                    if (nrow >= 0 && nrow < rowSize && ncol >= 0 && ncol < colSize
                            && grid[nrow][ncol] == '1' && !visited[nrow][ncol]) {
                        visited[nrow][ncol] = true;
                        vertexQueue.add(new Pair(nrow, ncol));
                    }
                }
            }

        }
    }
}
