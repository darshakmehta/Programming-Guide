class Solution { //39ms
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int x = matrix[i][j];
                for(int k = 0; k < matrix.length; k++) {
                    int m = i + 1;
                    int n = j + 1;
                    if(m < matrix.length && n < matrix[0].length) {
                        if(x != matrix[m][n]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}

/* Improving by going one row and one column less */
class Solution { //23ms
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix[0].length - 1; j++) {
                int x = matrix[i][j];
                for(int k = 0; k < matrix.length; k++) {
                    int m = i + 1;
                    int n = j + 1;
                    if(m < matrix.length && n < matrix[0].length) {
                        if(x != matrix[m][n]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}

/* Improved to loop from k = i, to cut down the unnecessary checks */
class Solution {//33ms
    public boolean isToeplitzMatrix(int[][] matrix) {
                
        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix[0].length - 1; j++) {
                int x = matrix[i][j];
                for(int k = i; k < matrix.length; k++) {
                    int m = i + 1;
                    int n = j + 1;
                    if(m < matrix.length && n <matrix[0].length) {
                        if(x != matrix[m][n]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}

/* Realized no need of entire 3rd loop */ 
class Solution {//22ms
    public boolean isToeplitzMatrix(int[][] matrix) {

        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix[0].length - 1; j++) {
                        if(matrix[i][j] != matrix[i + 1][j + 1]) {
                            return false;
                        }
            }
        }
        return true;
    }
}

/***

Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?

What if the matrix is so large that you can only load up a partial row into the memory at once? {98% faster}

Answers: Refer to https://leetcode.com/problems/toeplitz-matrix/discuss/147808/Java-Answers-to-the-follow-ups-(load-partial-rowcolumn-one-time)-the-3rd-one-beats-98

**/