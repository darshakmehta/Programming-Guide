class Solution {
    public List<String> commonChars(String[] A) {
        int[][] arr = new int[A.length][26];
        List<String> result = new ArrayList<String>();
        
        for ( int k = 0; k < A.length; k++ ) {
            for ( char c : A[k].toCharArray() ) {
                arr[k][c - 'a'] += 1;
            }
        }

        for ( int i = 0; i < 26; i++ ) {
            int min = Integer.MAX_VALUE;
            for ( int j = 0; j < A.length; j++ ) {
                if ( arr[j][i] < min ) {
                    min = arr[j][i];
                }
            }

            while ( min != 0 ) {
                result.add( ( (char)('a' + i) + "") );
                min--;
            }
        }
        
        return result;
    }
}