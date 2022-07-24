class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstCol = false;
        boolean isFirstRow = false;

        for (int i = 0; i < matrix.length; i++) { // check for first col
            if (matrix[i][0] == 0) {
                isFirstCol = true;
                break;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) { // check for first row
            if (matrix[0][j] == 0) {
                isFirstRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) { // check except first row and col; use first row and col as marker
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) { // first run we do not mark visited to avoid missing row or col with multiple 0's.
                    matrix[0][j] = 0; // jth col should be set to zero
                    matrix[i][0] = 0; // ith row should be set to zero
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { // if we market col or row zero set entire row or col to zero.
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRow) { // handle the first row
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isFirstCol) { // handle the second row
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
