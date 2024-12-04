class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<int[]>();
        int n = intervals.length;

        int i = 0;
        // no overlap
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // in case of overlap
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // no overlap after insertion
        while (i < n) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
