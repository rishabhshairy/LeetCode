class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, answer, new ArrayList<Integer>());
        return answer;

    }

    private void solve(int[] nums, int start, List<List<Integer>> answer, ArrayList<Integer> currList) {
        answer.add(new ArrayList<>(currList));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                currList.add(nums[i]);
                solve(nums, i + 1, answer, currList);
                currList.remove(currList.size() - 1);
            }
    }
}
