class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int n = a.length();
        int m = b.length();

        if (n < m) {
            return addBinary(b, a);
        }

        int carry = 0;
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            int bit1 = a.charAt(i) - '0';
            int sum = bit1 + carry;

            if (j >= 0) {
                int bit2 = b.charAt(j) - '0';
                sum += bit2;
                j--;
            }

            int currentBit = sum % 2;
            carry = sum / 2;

            sb.append((char) (currentBit + '0'));
        }

        if (carry > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
