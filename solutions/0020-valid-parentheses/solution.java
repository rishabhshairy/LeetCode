class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        if (s.length()==1){
            return false;
        }
        for (char c :
                s.toCharArray()) {
            if (c == '(') {
                brackets.push(')');
            } else if (c == '{') {
                brackets.push('}');
            } else if (c == '[') {
                brackets.push(']');
            } else {
                if ( !brackets.isEmpty() && c == brackets.peek() ) {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
