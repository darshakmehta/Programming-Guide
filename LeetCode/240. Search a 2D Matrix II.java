class Solution { // Accepted but linear search in entire one row
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        for(int i = 0; i < m; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == target)
                        return true;
                }
            }
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0, col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                ++row;
            } else {
                --col;
            }
        }
        return false;
    }
}
