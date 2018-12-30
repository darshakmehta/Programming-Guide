class Solution {
    public String reverseVowels(String s) {
        if( s == null || s.equals("") ) return "";
        
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        
        int x = -1, y = -1;
        
        while ( i < j ) {
            
            if( x == -1 && ( ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || 
                 ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U' )  ) {
                x = i;
            } else if(x == -1) {
                    i++;
            }
            
            if( y == -1 && ( ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u' || 
                 ch[j] == 'A' || ch[j] == 'E' || ch[j] == 'I' || ch[j] == 'O' || ch[j] == 'U' )  ) {
                y = j;
            } else if( y == -1 ) {
                    j--;
            }
            
            if( x != -1 && y != -1 ) {
                char temp = ch[x];
                ch[x] = ch[y];
                ch[y] = temp;
                x = y = -1;
                i++;
                j--;
            }
        }
        
        return String.valueOf(ch);
    }
}