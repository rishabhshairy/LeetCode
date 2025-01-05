class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
         int n = s.length();
        int[] shiftDiff = new int[n + 1];
        char[] schars = s.toCharArray();

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // forward direction
            shiftDiff[start] += (direction == 1 ? 1 : -1);

            // backward
            if (end + 1 < n) {
                shiftDiff[end + 1] -= (direction == 1 ? 1 : -1);
            }
        }
        
        int currShift = 0;
        for (int i = 0; i < n; i++) {
            currShift += shiftDiff[i];
            shiftDiff[i] = currShift;
            System.out.print(shiftDiff[i] + " ");
        }

        for (int i = 0; i < schars.length; i++) {
            int totalShift = (shiftDiff[i] % 26) + 26;
            char ch = (char) ((char) ((schars[i] - 'a' + totalShift) % 26) + 'a');
            schars[i] = ch;
        }
        return String.valueOf(schars);
    }
}
