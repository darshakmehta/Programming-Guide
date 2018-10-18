class Solution { //Accepted but linear search in entire one row
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

class Solution { //Binary search on entire matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(col >= 0 && row <= matrix.length - 1) {
            if(matrix[row][col] == target) return true;
            if(target < matrix[row][col]) col--;
            else if(target > matrix[row][col]) row++;
        }
        return false;
    }
}