class Solution {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		Set<Integer> numSet = new LinkedHashSet<>();
		int count = 1;

		for (int num : nums) {
			numSet.add(num);
		}

		for (Integer num : numSet) {
			if (!numSet.contains(num - 1)) {
				int next = num;
				int currCount = 1;

				// check if set contains x --> x+n
				while (numSet.contains(next + 1)) {
					next++;
					currCount++;
				}
				count = Math.max(count, currCount);
			}
		}
		return count;
	}
}
