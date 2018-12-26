class Solution {
    public String customSortString(String S, String T) {
        if(S.equals("")) return T;
        
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        Set<Character> set = new HashSet<Character>();
        int order = 26;
        char[] arr = new char[27];
        
        for ( char c : S.toCharArray() ) {
            arr[order--] = c;
            set.add(c);
        }
         
        for ( char c : T.toCharArray() ) {
            hmap.put( c, hmap.getOrDefault( c, 0 ) + 1 );
        }
        
        StringBuilder sb = new StringBuilder();
        for ( int i = 26; i >= 1; i-- ) {
            if( hmap.containsKey(arr[i]) ) {
                int count = hmap.get(arr[i]);
                
                for ( int j = 1; j <= count; j++) {
                    sb.append(arr[i]);
                }
            }
        }
        
        for ( char c :  T.toCharArray() ) {
            if( !set.contains(c) ) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}