class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, result, new ArrayList<>(), candidates.length);
        return result;

    }

    public void findCombinations(int index, int[] arr, int target, List<List<Integer>> result, List<Integer> nums, int length) {
        if (index == length) {
            if (target == 0) {
                result.add(new ArrayList<>(nums));
            }
            return;
        }

        if (arr[index] <= target) {
            nums.add(arr[index]);
            findCombinations(index, arr, target - arr[index], result, nums, length);
            nums.remove(nums.size() - 1);
        }
        findCombinations(index + 1, arr, target, result, nums, length);
    }
}
