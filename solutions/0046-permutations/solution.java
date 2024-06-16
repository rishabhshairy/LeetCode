class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> allPerm = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        findPermutation(nums, left, right, allPerm);
        return allPerm;
    }
    private void findPermutation(int[] num, int left, int right, List<List<Integer>> answer) {

        if (left == right) {
            List<Integer> permutuedArray = new ArrayList<>();
            for (Integer i :
                    num) {
                permutuedArray.add(i);
            }
            answer.add(permutuedArray);
        } else {
            for (int i = left; i <= right; i++) {
                num = swap(num, left, i);
                findPermutation(num, left + 1, right, answer);
                num = swap(num, left, i);
            }

        }
    }

    private int[] swap(int[] num, int left, int i) {
        int temp = num[left];
        num[left] = num[i];
        num[i] = temp;
        return num;
    }
}
