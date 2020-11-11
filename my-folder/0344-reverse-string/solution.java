class Solution {
    public void reverseString(char[] s) {
		int leftIndex = 0;
		int rightIndex = s.length - 1;
		char leftChar = 0;
		char rightChar = 0;
		for (int i = 0; i < s.length; i++) {
			leftChar = s[leftIndex];
			rightChar = s[rightIndex];
			s[leftIndex] = rightChar;
			s[rightIndex] = leftChar;
			if (rightIndex - leftIndex <= 1) {
				break;
			}
			leftIndex++;
			rightIndex--;
		}
    }
}
