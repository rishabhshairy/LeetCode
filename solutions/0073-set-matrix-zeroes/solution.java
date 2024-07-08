class Solution {
    public void setZeroes(int[][] matrix) {
 // here row will be matrix[..][0]
        // here col will be matrix[0][..]
        int col0 = 1;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {

                    // mark internal row as zero
                    matrix[i][0] = 0;

                    // mark only if j is not zero
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }

                }
            }
        }

        // Now traverse matrix from 1 --> length
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }

            }
        }

        // Imp step first mark zeros on col ***
        if (matrix[0][0] == 0) {
            for (int j = 0; j < colSize; j++) {
                matrix[0][j] = 0;
            }
        }

        // Now Solve row which is vertical which depends on col0
        if (col0 == 0) {
            for (int i = 0; i < rowSize; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
