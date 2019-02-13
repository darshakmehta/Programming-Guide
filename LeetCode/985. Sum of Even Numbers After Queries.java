class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int evenSum = 0;
        
        for ( int i : A ) {
            evenSum += (i % 2 == 0) ? i : 0;
        }
        
        for ( int i = 0; i < queries.length; i++ ) {
            
            if ( A[queries[i][1]] % 2 == 0 ) {
                evenSum -= A[queries[i][1]];
            }

            int x = A[queries[i][1]] + queries[i][0];
            
            if ( x % 2 == 0 ) {
                evenSum += x;
                A[queries[i][1]] = x;
            } else {
                A[queries[i][1]] = x;
            }
            result[i] = evenSum;
            
        }
        
        return result;
    }
}