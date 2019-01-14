class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        
        for ( char c : s.toCharArray() ) {
            if ( !hmap.containsKey(c) ) {
                sb.append(c);
                hmap.put(c, 1);
            } else {
                hmap.put(c, hmap.get(c) + 1);
            }
        }
        
        int result = 0; 
        
        boolean flag = false;
        for ( char c : sb.toString().toCharArray() ) {
            int x = hmap.get(c);
            if( !flag && x == 1 ) {
                flag = true;
                result += 1;
            } else if ( x % 2 == 0 ) {
                result += x;
            } else if ( (x - 1) % 2 == 0 ) {
                result += x - 1;
                if ( !flag ) {
                    flag = true;
                    result += 1;
                }
            }
        }
        
        return result;
        
    }
}