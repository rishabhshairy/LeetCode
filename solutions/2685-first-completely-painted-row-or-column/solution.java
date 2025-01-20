class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> matPositionMap = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;

        int[] rowFreq = new int[row];
        int[] colFreq = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matPositionMap.put(mat[i][j], new int[] { i, j });
            }
        }

        for (int i = 0; i < row * col; i++) {
            // find current position from elements in arr
            int[] currPos = matPositionMap.get(arr[i]);
            int currRow = currPos[0];
            int currCol = currPos[1];

            // increment and check freq of row and column if count is same to rowSize and
            // colSize return i
            if (++rowFreq[currRow] == col) {
                return i;
            }
            if (++colFreq[currCol] == row) {
                return i;
            }
        }

        return 0;
    }
}
