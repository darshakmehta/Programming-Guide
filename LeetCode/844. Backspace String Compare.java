class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        StringBuffer result1 = new StringBuffer();
        StringBuffer result2 = new StringBuffer();
        
        for ( char c :  S.toCharArray() ) {
            if ( c != '#' ) {
                result1.append(c);
            } else {
                if(result1.length() != 0)
                    result1.setLength(result1.length() - 1);
            }
        }
        
        for ( char c :  T.toCharArray() ) {
            if ( c != '#' ) {
                result2.append(c);
            } else {
                if(result2.length() != 0)
                    result2.setLength(result2.length() - 1);
            }
        }
        
        return result1.toString().equals(result2.toString());
        
    }
}