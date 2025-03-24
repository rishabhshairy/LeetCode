class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 1) {
            return days - meetings[0][1] - meetings[0][0] + 1;
        }

        Arrays.sort(meetings, (x, y) -> x[0] - y[0]);
        List<int[]> merged = new ArrayList<>();

        int[] prevMeeting = meetings[0];
        merged.add(prevMeeting);

        for (int[] currMeeting : meetings) {
            if (currMeeting[0] <= prevMeeting[1]) {
                prevMeeting[1] = Math.max(prevMeeting[1], currMeeting[1]);
            } else {
                merged.add(currMeeting);
                prevMeeting = currMeeting;
            }
        }
        int[][] mergedMeeting = merged.toArray(new int[merged.size()][]);

        for (int[] meeting : mergedMeeting) {
            days -= meeting[1] - meeting[0] + 1;
        }
        return days;
    }
}
