class Solution {
    public boolean isIsomorphic(String s, String t) {
        		if (s.length() != t.length()) {
			return false;
		}

		int[] smap = new int[256];
		int[] tmap = new int[256];
		int n = s.length();

		for (int i = 0; i < n; i++) {

			if (smap[s.charAt(i)] != tmap[t.charAt(i)]) {
				return false;
			}

			smap[s.charAt(i)] = i + 1;
			tmap[t.charAt(i)] = i + 1;

		}
		return true;
    }
}
