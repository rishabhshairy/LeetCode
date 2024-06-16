class Solution {
    public int[][] merge(int[][] intervals) {
                ArrayList<int[]> result = new ArrayList<>();

        if (intervals.length == 0 || intervals == null) {
            return result.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int min = intervals[0][0];
        int max = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > max) {

                result.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];

            } else if (intervals[i][1] >= max) {

                max = intervals[i][1];
            }
        }

        result.add(new int[]{min, max});
        return result.toArray(new int[0][]);
    }
}
