class Solution {
    
    public int countPrimeSetBits(int L, int R) {
        
        int result = 0;
        int[] isPrime = new int[20];
        
        /* Prime Numbers Initialization */
        isPrime[0] = 0; isPrime[1] = 0;
        for ( int i = 2; i <= 19; i++ ) {
            isPrime[i] = 1;
        }
        
        /* Prime Number */
        for ( int i = 2; i <= 19; i++ ) {
            for ( int j = 2; j <= Math.sqrt(i); j++ ) {
                if(i % j == 0) {
                    isPrime[i] = 0;
                    break;
                }
            }
        }
        
        for ( int i = L; i <= R; i++ ) {
            String s = Integer.toBinaryString(i); //Binary Bits of a Number
            int count = 0;
            for ( int j = 0; j < s.length(); j++ ) {
                if(s.charAt(j) == '1') count++; //Count set bits
            }
            
           if(isPrime[count] == 1) result++;
        }
        
        return result;
    }
}