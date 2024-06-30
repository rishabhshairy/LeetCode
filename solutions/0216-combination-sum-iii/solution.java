class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int s = n;
        findCombinationAnotherApproach(1, k, s, n, new ArrayList<>(), result);
        return result;
    }

    private static void findCombinationAnotherApproach(int index, int k, int s, int sum, List<Integer> answer,
            List<List<Integer>> result) {
        if (sum == 0 && answer.size() == k) {
            result.add(new ArrayList<>(answer));
            return;
        }
        // s is copy of sum , since we will reduce sum
        for (int num = index; num < s; num++) {
            if (num <= sum && num <= 9) {
                answer.add(num);
                findCombinationAnotherApproach(num + 1, k, s, sum - num, answer, result);
                answer.remove(answer.size() - 1);
            }
        }
    }
}
