class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> hmap = new HashMap<Character, String>();
        String[] arr = str.split(" ");
        int i = 0, j = 0;
        char[] c = pattern.toCharArray();
        
        for ( i = 0; i < arr.length && j < c.length; j++ ) {
            if( !hmap.containsKey(c[j]) ) {
                if( hmap.containsValue(arr[i]) ) return false;
                hmap.put(c[j], arr[i++]);
            } else {
                if ( !hmap.get(c[j]).equals(arr[i]) ) return false;
                else i++;
            }
        }
        
        if( j != c.length || i != arr.length ) return false;
        return true;
    }
}