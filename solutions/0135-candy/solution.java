class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] total = new int[n];
        Arrays.fill(total, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                total[i] = total[i - 1] + 1;
            }

        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && total[i] <= total[i + 1]) {
                total[i] = total[i + 1] + 1;
            }

        }
        return Arrays.stream(total).sum();
    }
}
