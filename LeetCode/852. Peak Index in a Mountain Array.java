class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int x = 1;
        int result = 0;
        for(int i = 1; i < A.length - 1; i++) {
            
            if(x == 1) {
                if(A[i] > A[i - 1]) {
                    result = i;
                } else {
                    x = 2;
                } 
            } 
            if(x == 2) {
                if(A[i] < A[i + 1]) {
                    result = i;
                }
            }
        }
        return result;
    }
}