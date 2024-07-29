class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] frontDp = new int[n];
        int[] currDp = new int[n];
        for (int j = 0; j < n; j++) {
            frontDp[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + frontDp[j];
                int diag = triangle.get(i).get(j) + frontDp[j+1];
                currDp[j] = Math.min(down, diag);
            }
            frontDp = currDp.clone();
        }
        return frontDp[0];
    }
}
