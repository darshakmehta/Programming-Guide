class Solution {
    public int numSpecialEquivGroups(String[] A) {
        
        Set<String> set = new HashSet<String>();
        
        int count = A.length;
        for ( String word : A ) {
            
            if( !set.contains( word ) ) {
                
                StringBuilder sb = new StringBuilder();
                
                for ( int i = 0; i < word.length(); i++ ) {
                    String s = word.substring( i, word.length() ) + word.substring( 0, i );
                    System.out.println(s);
                    set.add(s);
                }
                System.out.println();
            } else {
                count--;
            }
        }
        
        return count;
    }
}

/** TODO: https://leetcode.com/problems/groups-of-special-equivalent-strings/discuss/163413/Java-Concise-Set-Solution **/

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set= new HashSet<>();
        
        for ( String word : A ){
            
            int[] odd= new int[26];
            int[] even= new int[26];
            
            for ( int i = 0; i < word.length(); i++ ) {
                if ( i % 2 == 0 )  
                    even[word.charAt( i ) - 'a']++;
                else 
                    odd[word.charAt( i ) - 'a']++;
            }
            
            String s = Arrays.toString( odd ) + Arrays.toString( even );
            set.add( s );
        }
        return set.size();
    }
}