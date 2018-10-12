class Solution {
    public void rotate(int[][] matrix) {
        
        if(matrix == null|| matrix.length ==0 || matrix[0].length ==0) return;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        if(row != col) return;

        for(int i = 0; i <= row - i; i++){
            for(int j = i; j <= (row)-(i+1); j++){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-j][i];
                matrix[row-j][i] = matrix[row-i][row-j];
                matrix[row-i][row-j] = matrix[j][row-i];
                matrix[j][row-i] = temp ;
            }
        }
    }
}

/***

/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
void rotate(vector<vector<int> > &matrix) {
    reverse(matrix.begin(), matrix.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}

/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
void anti_rotate(vector<vector<int> > &matrix) {
    for (auto vi : matrix) reverse(vi.begin(), vi.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}

/*** 

TODO: Write the JAVA solution to rotate

***/