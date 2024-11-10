class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] smap = new int[256];
        int[] tmap = new int[256];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (smap[s.charAt(i)] != tmap[t.charAt(i)]) {
                return false;
            }
            smap[s.charAt(i)] = i + 1;
            tmap[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
