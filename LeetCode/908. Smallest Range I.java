class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = A[0];
        int min = A[0];
        
        for(int a :  A) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        
        return Math.max(0, max - min - K * 2);
    }
}