class Solution {
    List<Integer> result = new ArrayList<Integer>();
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0) return result;
        recursiveTraverse(matrix, 0, matrix.length, matrix[0].length);
        return result;
    }
    
    private void recursiveTraverse(int[][] matrix, int offset, int row, int column) {
        if (row == 0 || column == 0) return;
        
        if (row == 1) {
            for (int i = 0; i < column; i++) {
                result.add(matrix[offset][offset + i]); 
            }    
            return;
        }
        
        if (column == 1) {
            for (int i = 0; i < row; i++) {
                result.add(matrix[offset + i][offset + column - 1]);
            }
            return;
        }
				
        for (int i = 0; i < column - 1; i++) 
            result.add(matrix[offset][offset + i]);
        for (int i = 0; i < row - 1; i++) 
            result.add(matrix[offset + i][offset + column - 1]);
        for (int i = column - 1; i > 0; i--) 
            result.add(matrix[offset + row - 1][offset + i]);
        for (int i = row - 1; i > 0; i--) 
            result.add(matrix[offset + i][offset]);
        
        recursiveTraverse(matrix, offset + 1, row - 2, column - 2);
    }
}