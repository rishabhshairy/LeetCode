class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && boxes.charAt(j) != '0') {
                    result[i] += Math.abs(i - j);
                }
            }
            // System.out.println(result[i]);
        }

        return result;
    }
}
