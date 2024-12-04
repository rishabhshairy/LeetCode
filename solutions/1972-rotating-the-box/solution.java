class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int row = boxGrid.length;
        int col = boxGrid[0].length;
        char[][] rotatedBox = new char[col][row];

        // transpose matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotatedBox[j][i] = boxGrid[i][j];
            }
        }

        // rotate the box 90 degrees by reversing the row
        for (char[] currRow : rotatedBox) {
            int i = 0, j = currRow.length - 1;
            while (i < j) {
                char temp = currRow[i];
                currRow[i] = currRow[j];
                currRow[j] = temp;
                i++;
                j--;
            }
        }
        // now operate on each column
        // start from bottom

        for (int j = 0; j < row; j++) {
            // process column from bottom to top
            int lowestEmpty = col - 1;
            for (int i = col - 1; i >= 0; i--) {

                if (rotatedBox[i][j] == '#') {
                    rotatedBox[i][j] = '.';
                    rotatedBox[lowestEmpty][j] = '#'; // stone fell
                    lowestEmpty--;
                }

                // if obstacle is found, reduce lowestEmpty to one cell above
                if (rotatedBox[i][j] == '*') {
                    lowestEmpty = i - 1;
                }
            }
        }

        return rotatedBox;
    }
}
