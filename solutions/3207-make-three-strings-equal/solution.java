class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
                int longest = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        int minLength = Math.min(n1, Math.min(n2, n3));

        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)  && s2.charAt(i) == s3.charAt(i)) {
            i++;
            longest++;
        }

        if (i == 0) {
            return -1;
        }

        //System.out.println(s1.substring(0, i));

        return (n1 - longest) + (n2 - longest) + (n3 - longest);
    }
}
