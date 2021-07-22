class Solution {
    public String removeDuplicateLetters(String s) {
        Set<Character> dupSet = new HashSet<>();
        Stack<Character> characterStack = new Stack<>();

        int[] occurence = new int[128];
        for (int i = 0; i < s.length(); i++) {
            occurence[s.charAt(i)] = i;
        }

        int i = 0;
        for (Character ch :
                s.toCharArray()) {
            while (dupSet.add(ch)) {
                while (!characterStack.isEmpty() && characterStack.peek() > ch && occurence[characterStack.peek()] > i) {
                    dupSet.remove(characterStack.pop());
                }
                characterStack.push(ch);
            }
            i++;

        }
        StringBuilder sb=new StringBuilder();
        for (Character ch:
             characterStack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
