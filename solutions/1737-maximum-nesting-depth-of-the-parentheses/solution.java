class Solution {
    public int maxDepth(String s) {
        int maxLen = Integer.MIN_VALUE;
        int count = 0;

        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                maxLen = Math.max(maxLen, count);
                count--;
            }
        }
        //System.out.print(maxLen);
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
