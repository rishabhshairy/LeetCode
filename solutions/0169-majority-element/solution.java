class Solution {
    public int majorityElement(int[] a) {
        int probableElement = probableCandiate(a, a.length);
        if (a.length == 1) {
			return a[0];
		}
		
		if (a.length == 2 && a[0]==a[1]) {
			return a[0];
		} 

		
		int elemCount = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == probableElement) {
				elemCount++;
			}
			if (elemCount > a.length / 2) {
				return probableElement;
			}
		}

		return -1;
    }
    static int probableCandiate(int[] a, int n)
	{
		int count = 1;
		int index = 0;

		for (int i = 1; i < a.length; i++) {
			if (a[index] == a[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				index = i;
				count = 1;
			}
		}
		return a[index];
	}
}
