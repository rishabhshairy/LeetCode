class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new TreeSet();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        int count = 1;
        List<Integer> list = new ArrayList<Integer>(numSet);
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 == list.get(i + 1)) {
                count++;
            } else {
                longest = Math.max(longest, count);
                count = 1;
            }
        }
        longest = Math.max(longest, count);
        return longest;
    }
}
