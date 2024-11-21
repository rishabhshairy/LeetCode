class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        int count = (m * n) - guards.length - walls.length;
        // mark gaurd cells
        for (int i = 0; i < guards.length; i++) {
            int row = guards[i][0];
            int col = guards[i][1];
            grid[row][col] = 'g';
        }

        // mark walls
        for (int i = 0; i < walls.length; i++) {
            int row = walls[i][0];
            int col = walls[i][1];
            grid[row][col] = 'w';
        }

        int[] deltaRow = { -1, 0, 1, 0 };
        int[] deltaCol = { 0, 1, 0, -1 };

        for (int[] currGuard : guards) {
            int currRow = currGuard[0];
            int currCol = currGuard[1];

            for (int j = 0; j < 4; j++) {
                int nextRow = currRow + deltaRow[j];
                int nextCol = currCol + deltaCol[j];

                while (!(nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n
                        || grid[nextRow][nextCol] == 'g' || grid[nextRow][nextCol] == 'w')) {

                    if (grid[nextRow][nextCol] != 'p') {
                        count--;
                    }
                    grid[nextRow][nextCol] = 'p';

                    // now traverse from this next protected position
                    nextRow += deltaRow[j];
                    nextCol += deltaCol[j];

                }
            }
        }
        return count;
    }
}
