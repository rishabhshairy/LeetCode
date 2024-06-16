class Solution {
    public String sortSentence(String s) {
        String mod = s.trim();
        String[] allWords = mod.split("\\s+");
        String[] newSentence = new String[allWords.length + 1];
        for (String word :
                allWords) {
            int index = Integer.parseInt(String.valueOf(word.charAt(word.length() - 1)));
            newSentence[index] = word.substring(0, word.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String word :
                newSentence) {
            if (!(word == null)) {
                sb.append(word);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
