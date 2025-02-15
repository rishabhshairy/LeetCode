class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            // add 1 and return if last digit is < 9
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // make current digit 0 if == 9
            digits[i] = 0;
        }

        // add 1 to 0th position
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }
}
