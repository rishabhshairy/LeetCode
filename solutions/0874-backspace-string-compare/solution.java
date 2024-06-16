class Solution {
    public boolean backspaceCompare(String S, String T) {
        	if (T == null || S == null) {
			return false;
		}
		if (T.length() == 0 || S.length() == 0) {
			return true;
		}

		Stack<Character> stackOfS = new Stack<>();
		Stack<Character> stackOfT = new Stack<>();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) != '#') {
				stackOfS.push(S.charAt(i));
			} else if (S.charAt(i) == '#' && !stackOfS.isEmpty()) {
				stackOfS.pop();
			}
		}
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) != '#') {
				stackOfT.push(T.charAt(i));
			} else if (T.charAt(i) == '#' && !stackOfT.isEmpty()) {
				stackOfT.pop();
			}
		}
		if (stackOfS.toString().equals(stackOfT.toString())) {
			return true;
		}
		return false;
    }
}
