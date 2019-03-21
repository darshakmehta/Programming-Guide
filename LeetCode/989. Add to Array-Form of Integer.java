class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        int carry = 0;
        int i = A.length - 1;
        for ( ; K != 0 && i >= 0; i-- ) {
            int x = carry + A[i] + K % 10;
            carry = x / 10;
            
            result.add(0, x % 10);
                       
            K = K / 10;
        }
        
        for ( ; i >= 0; i-- ) {
            int x = carry + A[i];
            carry = x / 10;
            
            result.add(0, x % 10);
        }

        while ( K != 0 ) {
            int x = carry + K % 10;
            carry = x / 10;
            
            result.add(0, x % 10);
            K = K / 10;
        }
    
        if ( carry == 1 ) {
            result.add(0, carry);
        }
        
        return result;
        
    }
}

/* Solution 2 */

 public List<Integer> addToArrayForm(int[] A, int K) {
        List res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; --i) {
            res.add(0, (i >= 0 ? A[i] + K : K) % 10);
            K = (i >= 0 ? A[i] + K : K) / 10;
        }
        return res;
    }