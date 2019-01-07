class Solution {
    public char findTheDifference(String s, String t) {
        
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for ( char c : s.toCharArray() ) 
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        
        for ( char c : t.toCharArray() ) {
            if( hmap.containsKey(c) ) {
                if( hmap.get(c) > 0 )
                    hmap.put(c, hmap.get(c) - 1);
                else
                    return c;
            } else {
                return c;
            }
        }
        
        return '\0';
    }
}

/* Without Space */

class Solution {
    public char findTheDifference(String s, String t) {
        int charCode = t.charAt(s.length());
        for (int i = 0; i < s.length(); ++i) {
              charCode -= (int)s.charAt(i);
              charCode += (int)t.charAt(i); 
        }
        return (char)charCode;
    }
}