class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuffer result = new StringBuffer();
        int j = 0;
        boolean flag = true;
        while ( j < n ) {
            
            if( j + k < n ) {
                result.append(new StringBuilder(s.substring(j, j + k)).reverse());
                j += k;
            } else {
                flag = true;
                break;   
            }
            
            if ( j + k < n) {
                result.append(s.substring(j, j + k));
                j += k;
            } else {
                flag = false;
                break;
            }
            
        }
        
        if(flag)
            result.append(new StringBuilder(s.substring(j)).reverse());
        else
            result.append(s.substring(j));
        
        return result.toString();
        
    }
}

/*

TODO: Use char[] and reverse to avoid generating new String for every substring call

*/