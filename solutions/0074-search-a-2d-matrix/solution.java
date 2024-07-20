class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = (row * col) - 1; // assuming 1D matrix hypothetically

        while (low <= high) {
            int mid = (low + high) / 2;

            int mappedRow = mid / col;
            int mappedCol = mid % col;
            int mappedNumber = matrix[mappedRow][mappedCol];

            if (mappedNumber == target) {
                return true;
            } else if (mappedNumber > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return false;
    }
}
