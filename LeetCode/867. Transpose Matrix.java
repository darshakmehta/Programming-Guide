class Solution { //100% solution
    public int[][] transpose(int[][] A) {
        int [][] result = new int[A[0].length][A.length];  
        
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}