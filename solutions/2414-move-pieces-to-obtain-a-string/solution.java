class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0, n = start.length();

        while (i < n || j < n) {
            // skip if _

            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            // if whole string is empty
            if (i == n || j == n) {
                break;
            }

            // to check order of character
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            // eg s='L_' and t='_L'
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }

            // eg:: s='_R' t='R_'
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }

        return i == n && j == n;
    }
}
