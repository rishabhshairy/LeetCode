class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int left = 0;
        while (left < word.length()) {
            int count = 0;
            char curr = word.charAt(left);

            while (left < word.length() && count < 9 && word.charAt(left) == curr) {
                count++;
                left++;
            }
            comp.append(count).append(curr);
        }

        return comp.toString();
    }
}
