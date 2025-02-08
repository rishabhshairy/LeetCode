class Solution {
    public int[][] generateMatrix(int n) {
        		if (n == 1) {
			return new int[][]{{1}};
		}
		
		int row = n;
		int col = n;
		int[][] grid = new int[row][col];
		List<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 1; i <= n*n; i++) {
			nums.add(i);
		}
		int numIndex=0;
		
		int top = 0;
		int bottom = row - 1;
		int left = 0;
		int right = col- 1;
		int dir = 1; // 1 --> right, 2 --> down, 3 --> left, 4 --> up
			
		while (top <= bottom && left <= right) {

			if (dir == 1) {
				for (int i = left; i <= right; i++) {
					grid[top][i] = nums.get(numIndex);
					numIndex++;
				}
				dir = 2;
				top++;
			} else if (dir == 2) {
				for (int i = top; i <= bottom; i++) {
					grid[i][right] = nums.get(numIndex);
					numIndex++;
				}
				dir = 3;
				right--;
			} else if (dir == 3) {
				for (int i = right; i >= left; i--) {
					grid[bottom][i] = nums.get(numIndex);
					numIndex++;
				}
				dir = 4;
				bottom--;
			} else {
				for (int i = bottom; i >= top; i--) {
					grid[i][left] = nums.get(numIndex);
					numIndex++;
				}
				left++;
				dir=1;
			}
		}
		return grid;
    }
}
