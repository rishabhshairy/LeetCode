class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        findPartitions(0, s, answer, result);
        return result;
    }

    private void findPartitions(int index, String s, List<String> answer, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(answer));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                answer.add(s.substring(index, i + 1));
                findPartitions(i + 1, s, answer, result);
                answer.remove(answer.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
