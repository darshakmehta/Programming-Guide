class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        int pos = 0;
        for(int i = 0; i < A.length - 1; i++) {
            pos = i;
            if(A[i] < A[i + 1]) {
                if(i == A.length - 2)
                    return false;
                continue;
            } else {
                break;
            }
        }
        if(pos == 0) return false;
        for(int i = pos; i < A.length - 1; i++) {
            if(A[i] > A[i + 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}