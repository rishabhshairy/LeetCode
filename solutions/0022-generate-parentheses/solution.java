class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        String output = "";
        solveDiffApproach(0,0,output,answer,n);
        return answer;
    }

    public static void solveDiffApproach(int leftBracket, int rightBracket, String out, List<String> answer, int n) {
        if (out.length() == 2 * n) {
            answer.add(out);
            return;
        }

        if (leftBracket < n) {
            solveDiffApproach(leftBracket + 1, rightBracket, out + "(", answer, n);
        }

        if (rightBracket < leftBracket) {
            solveDiffApproach(leftBracket, rightBracket + 1, out + ")", answer, n);
        }
    }
}
