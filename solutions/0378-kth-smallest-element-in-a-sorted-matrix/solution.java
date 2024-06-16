class Solution {
        public int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> allNum = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                allNum.add(matrix[i][j]);
            }
        }

        Collections.sort(allNum);
        return allNum.get(k - 1);
        }
}
