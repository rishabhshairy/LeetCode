class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        HashMap<Integer, String> letterCombinationMap = new HashMap<>();

        letterCombinationMap.put(2, "abc");
        letterCombinationMap.put(3, "def");
        letterCombinationMap.put(4, "ghi");
        letterCombinationMap.put(5, "jkl");
        letterCombinationMap.put(6, "mno");
        letterCombinationMap.put(7, "pqrs");
        letterCombinationMap.put(8, "tuv");
        letterCombinationMap.put(9, "wxyz");

        if (digits.length() == 0) {
            return answer;
        }
        StringBuilder sb = new StringBuilder();
        helper(sb, letterCombinationMap, answer, digits, 0);

        return answer;
    }
    private void helper(StringBuilder sb, Map<Integer, String> map, List<String> answer, String input, int startIndex) {
        if (sb.length() == input.length()) {
            answer.add(sb.toString());
            return;
        }

        for (int i = startIndex; i < input.length(); i++) {
            String start = map.get(Integer.parseInt(String.valueOf(input.charAt(i))));
            for (int j = 0; j < start.length(); j++) {
                sb.append(start.charAt(j));
                helper(sb, map, answer, input, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

