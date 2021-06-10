class Solution {
    public int change(int n, int[] S) {
        int m = S.length;
        int[][] tdp = new int[m + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            tdp[0][i] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            tdp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S[i - 1] <= j) {
                    tdp[i][j] = tdp[i - 1][j] + tdp[i][j - S[i - 1]];
                } else {
                    tdp[i][j] = tdp[i - 1][j];
                }
            }
        }
        return tdp[m][n];
    }
}
