class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> pivotNums = new ArrayList<>();
        List<Integer> more = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                less.add(nums[i]);
            } else if (nums[i] == pivot) {
                pivotNums.add(pivot);
            } else {
                more.add(nums[i]);
            }
        }
        List<Integer> res = new ArrayList<>(less);
        res.addAll(pivotNums);
        res.addAll(more);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
