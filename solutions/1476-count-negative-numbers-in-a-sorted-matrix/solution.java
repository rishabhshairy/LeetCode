class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        int currRow = 0;
        int currCol = col - 1;

        while (currRow < row && currCol >= 0) {
            if (grid[currRow][currCol] >= 0) {
                currRow++;
            } else {
                count += (row - currRow);
                currCol--;
            }
        }
        return count;
    }
}
