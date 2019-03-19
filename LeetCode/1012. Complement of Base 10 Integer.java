/* Solution 1 */

class Solution {
    public int bitwiseComplement(int N) {
        
        if ( N == 0) return 1;
        
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        
        while ( N != 0 ) {
            sb.append(N%2);
            N = N / 2;
        }
        sb = sb.reverse();
        for ( int i = 0; i < sb.length(); i++ ) {
            sb2.append(((sb.charAt(i) - '0') == 1 ? 0 : 1));
        }

        int result = 0;
        
        for (int i = sb.length() - 1, j = 0; i >= 0 ; i--, j++) {
            result += ( sb2.charAt(i) - '0' ) * Math.pow(2, j);
        }
        
        return result;
    }
}

/* Solution 2 */

class Solution {
    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }
}

/* Solution 3 */

class Solution {
    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return N ^ X;
    }
}