class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballMap = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();
        int[] result = new int[queries.length];
        int index = 0;

        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];

            // put if ball is not in map
            if (!ballMap.containsKey(ball)) {
                ballMap.put(ball, color);
            } else {
                if (colorMap.get(ballMap.get(ball)) == 1) {
                    colorMap.remove(ballMap.get(ball));
                } else {
                    colorMap.put(ballMap.get(ball), colorMap.get(ballMap.get(ball)) - 1);
                }
                ballMap.put(ball,color);
            }

            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            result[index] = colorMap.size();
            index++;
        }
        return result;
    }
}
