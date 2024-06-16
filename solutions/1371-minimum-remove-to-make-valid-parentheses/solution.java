class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> brackets = new Stack<>();
        char[] allChars = s.toCharArray();

        for (int i = 0; i < allChars.length; i++) {
            Character ch = allChars[i];
            if (ch.equals('(')) {
                brackets.push(i);
            } else if (ch.equals(')')) {
                if (!brackets.isEmpty()) {
                    brackets.pop();
                } else {
                    allChars[i] = ' ';
                }
            }
        }

        while (!brackets.isEmpty()) {
            allChars[brackets.pop()] = ' ';
        }
        return String.valueOf(allChars).replaceAll(" ", "");
    }
}
