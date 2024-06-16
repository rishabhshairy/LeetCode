class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        		Set<Integer> a = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			a.add(nums2[i]);
		}

		Set<Integer> b = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			b.add(nums1[i]);
		}
		b.retainAll(a);
		int[] result = new int[b.size()];
		int index = 0;
		for (Integer i : b) {
			result[index] = i;
			index++;
		}
		return result;
    }
}
