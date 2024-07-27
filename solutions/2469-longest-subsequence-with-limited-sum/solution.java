class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
                Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[] answer = new int[m];

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int q = queries[i];
            int low = 0;
            int high = nums.length-1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == q) {
                    answer[i] = mid + 1;
                    break;
                } else if (nums[mid] < q) {
                    answer[i] = mid + 1;
                    low = mid + 1;
                } else {
                    high = mid - 1;

                }
            }
        }
        return answer;
    }
}
