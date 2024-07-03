class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length; // row
        int n = board[0].length; // column

        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (searchNextChar(i, j, board, word, index, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean searchNextChar(int row, int col, char[][] board, String word, int index, int m, int n) {
        // base case --> we found the word
        if (index == word.length()) {
            return true;
        }

        // check for boundary conditions
        if (row < 0 || col < 0 || row == m || col == n || board[row][col] != word.charAt(index)
                || board[row][col] == '!') {
            return false;
        }

        // Use ! to fill in already travelled positions
        char c = board[row][col];
        board[row][col] = '!';

        // search in top direction
        boolean top = searchNextChar(row - 1, col, board, word, index + 1, m, n);

        // search in right
        boolean right = searchNextChar(row, col + 1, board, word, index + 1, m, n);

        // search in bottom
        boolean bottom = searchNextChar(row + 1, col, board, word, index + 1, m, n);

        // search in left
        boolean left = searchNextChar(row, col - 1, board, word, index + 1, m, n);

        board[row][col] = c; // backtrack and put back

        return top || right || bottom || left;

    }
}
