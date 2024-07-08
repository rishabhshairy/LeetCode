class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;

        Set<Integer> numSet = new LinkedHashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (Integer currNum : numSet) {
            if (!numSet.contains(currNum - 1)) {
                int x = currNum;
                int currLongest = 1;

                while (numSet.contains(x + 1)) {
                    x++;
                    currLongest++;
                }
                longest = Math.max(longest, currLongest);
            }
        }
        return longest;
    }
}
