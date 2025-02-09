class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
		// declare 4 variables
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		int dir = 1; // 1 --> right, 2 --> down, 3 --> left, 4 --> up

		while (top <= bottom && left <= right) {

			if (dir == 1) {
				for (int i = left; i <= right; i++) {
					result.add(matrix[top][i]);
				}
				dir = 2;
				top++;
			} else if (dir == 2) {
				for (int i = top; i <= bottom; i++) {
					result.add(matrix[i][right]);
				}
				dir = 3;
				right--;
			} else if (dir == 3) {
				for (int i = right; i >= left; i--) {
					result.add(matrix[bottom][i]);
				}
				dir = 4;
				bottom--;
			} else {
				for (int i = bottom; i >= top; i--) {
					result.add(matrix[i][left]);
				}
				left++;
				dir=1;
			}
		}
		return result;
    }
}
