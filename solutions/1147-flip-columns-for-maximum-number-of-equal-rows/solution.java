class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternMap = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder val = new StringBuilder();
            StringBuilder flippedVal = new StringBuilder();

            for (int bit : row) {
                val.append(bit);
                flippedVal.append(1 - bit);
            }

            patternMap.put(val.toString(), patternMap.getOrDefault(val.toString(), 0) + 1);
            patternMap.put(flippedVal.toString(), patternMap.getOrDefault(flippedVal.toString(), 0) + 1);
        }
        return Collections.max(patternMap.values());
    }
}
