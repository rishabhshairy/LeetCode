class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[51];
        int[] result = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int valA = A[i];
            int valB = B[i];
            freq[valA]++;
            if (freq[valA] == 2) {
                count++;
            }
            freq[valB]++;
            if (freq[valB] == 2) {
                count++;
            }
            result[i]=count;
        }
        return result;
    }
}
