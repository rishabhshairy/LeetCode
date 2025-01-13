class Solution {
    static class Work {
        int difficulty;
        int profit;

        public Work(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Work[] works = new Work[n];
        for (int i = 0; i < n; i++) {
            works[i] = new Work(difficulty[i], profit[i]);
        }

        Arrays.sort(works, (x, y) -> x.difficulty - y.difficulty);


        // preprocess the max profit
        for (int i = 1; i < works.length; i++) {
            works[i].profit = Math.max(works[i - 1].profit, works[i].profit);
        }

        int[] maxProfits = new int[worker.length];

        for (int i = 0; i < worker.length; i++) {
            int currAbility = worker[i];
            int currProfit = solve(currAbility, works);
            if (currProfit != -1) {
                maxProfits[i] = currProfit;
            }
        }
        return Arrays.stream(maxProfits).sum();
    }

    private int solve(int currAbility, Work[] works) {
        int profit = -1;
        int left = 0;
        int right = works.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (currAbility >= works[mid].difficulty) {
                profit = works[mid].profit;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return profit;
    }
}
