class Solution {
    public int[] sortedSquares(int[] A) {
       int leftIndex = 0;
		int rightIndex = A.length - 1;
		int[] sqauredSorted = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			if (Math.abs(A[leftIndex]) > Math.abs(A[rightIndex])) {
				sqauredSorted[A.length - 1 - i] = A[leftIndex] * A[leftIndex];
				leftIndex++;
			} else {
				sqauredSorted[A.length - 1 - i] = A[rightIndex] * A[rightIndex];
				rightIndex--;
			}

		}
		return sqauredSorted;
    }
}
