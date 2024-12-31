class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        Set<Integer> daySet = new HashSet<>();

        // put all days in set
        for (int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
        }

        int[] dp = new int[maxDay + 1];

        for (int currentDay = 1; currentDay <= maxDay; currentDay++) {
            if (!daySet.contains(currentDay)) {
                dp[currentDay] = dp[currentDay - 1];

            } else {
                int oneDay = dp[currentDay - 1] + costs[0];

                 // taking max (0, currDay-7) to avoid negative index
                int sevenDayPass = dp[Math.max(0, currentDay - 7)] + costs[1]; 
                int thirtyDayPass = dp[Math.max(0, currentDay - 30)] + costs[2];
                dp[currentDay] = Math.min(oneDay, Math.min(sevenDayPass, thirtyDayPass));
            }
        }
        return dp[maxDay];
    }
}
