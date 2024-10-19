class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] patCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            patCount[p.charAt(i) - 'a']++;
        }
        int[] sCount = new int[26];
        int left = 0, right = 0;

        while (right < s.length()) {
            sCount[s.charAt(right) - 'a']++;

            if (right - left + 1 == p.length()) {
                if (Arrays.equals(patCount, sCount)) {
                    result.add(left);
                }
                sCount[s.charAt(left) - 'a']--;
                left++;
                right++;
            }

            if (right - left + 1 < p.length()) {
                right++;
            }
        }
        return result;
    }
}
