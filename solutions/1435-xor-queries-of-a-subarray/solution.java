class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        int[] prefixXor = new int[arr.length+1];
        prefixXor[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];

        }

        // now go through the query
        for (int i = 0; i < n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            result[i] = prefixXor[end + 1] ^ prefixXor[start];
        }

        return result;
    }
}
