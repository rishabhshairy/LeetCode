class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[256];
        int[] tChar = new int[256];

        for (int i = 0; i < s.length(); i++) {
            sChar[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            tChar[t.charAt(i)]++;
        }

        // now check char counts
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }
}
