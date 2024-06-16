class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answerList=new ArrayList<>();
        Set<Integer> dupSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dupSet.contains(nums[i])){
                answerList.add(nums[i]);
            } else {
                dupSet.add(nums[i]);
            }
        }
        return answerList;
    }
}
