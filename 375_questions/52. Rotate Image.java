class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null|| matrix.length == 0 || matrix[0].length == 0) return;

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        if (row != col) {
            return;
        }

        for (int i = 0; i <= row - i; i++) {
            for (int j = i; j <= (col - (i + 1)); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - j][i];
                matrix[row - j][i] = matrix[row - i][col - j];
                matrix[row - i][col - j] = matrix[j][col - i];
                matrix[j][col - i] = temp ;
            }
        }
    }
}
