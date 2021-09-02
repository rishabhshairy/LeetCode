class Solution {
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int start = 0;
        int end = s.length - 1;
        solve(s, start, end);
        System.out.println(s);
    }

    private void solve(char[] s, int start, int end) {
        if (start == s.length / 2) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        start++;
        end--;
        solve(s,start,end);
    }
}
