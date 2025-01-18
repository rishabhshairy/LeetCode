class Solution {
    public int jump(int[] arr) {
        int end = 0, far = 0;
		int minJumps = 0;

		for (int i = 0; i < arr.length-1; i++) {
			far = Math.max(far, arr[i] + i);

			// jumped to next region
			if (i == end) {
				minJumps += 1;
				end = far;
			}
		}
		return minJumps;
    }
}
