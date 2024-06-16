class Solution {
    public String reverseWords(String A) {
        String modify = A.trim();
        String[] allWords = modify.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = allWords.length - 1; i >= 0; i--) {
            if (allWords[i].length() > 0 && !allWords[i].equals(" ")) {
                sb.append(allWords[i].trim());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
