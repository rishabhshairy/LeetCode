class Solution {
    public int maxMoves(int[][] grid) {
        int maxRow = grid.length - 1;
        int maxCol = grid[0].length - 1;
        int[][] table = new int[maxRow + 1][maxCol + 1];
        int res = 0;

        for (int col = maxCol; col >= 0; col--) {
            for (int row = 0; row <= maxRow; row++) {
                int diagonalUp = 0, right = 0, diagonalDown = 0;

                if (row - 1 >= 0 && col + 1 <= maxCol && grid[row - 1][col + 1] > grid[row][col]) {
                    diagonalUp = 1 + table[row - 1][col + 1];
                }

                if (col + 1 <= maxCol && grid[row][col + 1] > grid[row][col]) {
                    right = 1 + table[row][col + 1];
                }

                if (row + 1 <= maxRow && col + 1 <= maxCol && grid[row + 1][col + 1] > grid[row][col]) {
                    diagonalDown = 1 + table[row + 1][col + 1];
                }

                table[row][col] = Math.max(diagonalUp, Math.max(right, diagonalDown));
                if (col == 0)
                    res = Math.max(res, table[row][0]);
            }
        }

        return res;
    }
}
