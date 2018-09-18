class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        int a[][] = new int[A.length][A[0].length];
        
        for(int i = 0; i < A.length; i++) {
                int n = A[0].length - 1;        
            for(int j = 0; j < A[0].length; j++) {
                    a[i][j] = A[i][n--];
            }
        }
        
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                if(a[i][j] == 0)
                    a[i][j] = 1;
                else
                    a[i][j] = 0;
            }
        }
        
        return a;
        
    }
}