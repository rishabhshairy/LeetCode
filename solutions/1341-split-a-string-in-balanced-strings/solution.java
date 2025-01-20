class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
		int balance = 0;
		for (int i = 0; i < s.length(); i++) {
			balance += s.charAt(i) == 'R' ? 1 : -1;
			if (balance == 0) {
				count++;
			}
		}
		return count;
    }
}
