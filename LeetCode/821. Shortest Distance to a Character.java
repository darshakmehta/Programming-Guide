class Solution {
    
    public static void findResult(int[] result, String S, char C) {
        int index = 0, prev = 0, k = 0;
        while ( index != -1 ) {
            index = S.indexOf(C, prev);
            if ( index != -1) {
                k = 0;
                for ( int i = index - 1; i >= prev; i-- ) {
                    result[i] = ++k;
                }    
            } else {
                k = 0;
                for ( int i = prev; i < S.length(); i++ ) {
                    result[i] = ++k;
                }
                break;
            }
            prev = index + 1;
        }
    }
    
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        int[] result1 = new int[S.length()];
        int[] result2 = new int[S.length()];
        int index = 0, prev = 0, k = 0;
        
       findResult(result1, S, C);
       StringBuffer sb = new StringBuffer(S);
       findResult(result2, sb.reverse().toString(), C);
        
       for (int i = 0, j = S.length() - 1; i < S.length() && j >= 0; i++, j-- ) {
           if( result1[i] > result2[j] ) {
               result[i] = result2[j];
           } else {
               result[i] = result1[i];
           }
       } 
        
        return result;
    }
}

/* 

TODO: without extra space 


*/