class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findUniqueCombinations(0, candidates, target, result, new ArrayList<Integer>());
        return result;
    }

    private  void findUniqueCombinations(int index, int[] arr, int target, List<List<Integer>> result, ArrayList<Integer> nums) {

        // base case
        if (target == 0) {
            result.add(new ArrayList<>(nums));
            return;
        }

        // looping through each element
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            // actual recursion call
            if (arr[i] <= target) {
                nums.add(arr[i]);
                findUniqueCombinations(i + 1, arr, target - arr[i], result, nums);
                nums.remove(nums.size() - 1);
            }
        }

    }
}
