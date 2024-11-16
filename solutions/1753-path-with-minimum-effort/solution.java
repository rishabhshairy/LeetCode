class Solution {
static class Node {
        int row, col, distanceDiff;

        public Node(int row, int col, int distanceDiff) {
            this.row = row;
            this.col = col;
            this.distanceDiff = distanceDiff;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int rowCount = heights.length;
        int colCount = heights[0].length;

        // create a distance array
        int[][] distance = new int[rowCount][colCount];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], (int) 1e9);
        }

        // initial config
        distance[0][0] = 0;

        PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>((x, y) -> x.distanceDiff - y.distanceDiff);
        nodeQueue.offer(new Node(0, 0, 0));

        // since we are allowed only in 4 direction
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!nodeQueue.isEmpty()) {
            Node currNode = nodeQueue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currDist = currNode.distanceDiff;

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + deltaRow[i];
                int nextCol = currCol + deltaCol[i];

                if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount) {
                    int newDiff = Math.max(Math.abs(heights[currRow][currCol] - heights[nextRow][nextCol]), currDist);
                    if (newDiff < distance[nextRow][nextCol]) {
                        int diff = Math.abs(heights[currRow][currCol] - heights[nextRow][nextCol]);
                        distance[nextRow][nextCol] = newDiff;
                        nodeQueue.offer(new Node(nextRow, nextCol, newDiff));
                    }
                }
            }
        }
        return distance[rowCount - 1][colCount - 1];
    }
}
