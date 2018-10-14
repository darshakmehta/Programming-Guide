class Solution {
    
    public void setZeroes(int[][] matrix) {
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) { 
                if(matrix[i][j] == 0) {
                    matrix[i][j] = 0;
                    for(int k = 0; k < matrix.length; k++) {
                            if(matrix[k][j] != 0)
                                matrix[k][j] = -1000000;
                    }
                    for(int k = 0; k < matrix[0].length; k++) {
                        if(matrix[i][k] != 0)
                            matrix[i][k] = -1000000;
                    }
                } 
            }
        }
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -1000000)
                    matrix[i][j] = 0;
            }
        }
        
    }
}

class Solution {
    
    public void setZeroes(int[][] matrix) {
        boolean isFirstCol = false;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) isFirstCol = true;
            for(int j = 1; j < matrix[0].length; j++) { 
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                } 
            }
        }
        
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        if(matrix[0][0] == 0) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(isFirstCol) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
}


/***

In solution 1, what is -1000000 value is present in the array, therefore it is incorrect solution

In solution 2, is correct solution

***/