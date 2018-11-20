class Solution {
    public int minDeletionSize(String[] A) {
        int result = 0;
        for(int c = 0; c < A[0].length(); c++) {
            for(int r = 0; r < A.length - 1; r++) {
                if(A[r].charAt(c) > A[r + 1].charAt(c)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}