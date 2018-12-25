/* Incorrect Logic - It does not consider the order of character of the word */
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] patternDict = new int[26];
        List<String> result = new ArrayList<String>();
        Map<String, Integer> hmap = new HashMap<String, Integer>();
        
        for(char c : pattern.toCharArray()) {
            patternDict[((int) c - 'a')]++;
        }
        
        for(int i = 0; i < 26; i++) {
            if(patternDict[i] > 0) {
                String s = "1-" + patternDict[i];
                hmap.put(s, hmap.getOrDefault(s, 0) + 1);
            }
        }
        
        
        for(String word : words) {
            
            int[] wordDict = new int[26];
            
            Map<String, Integer> cloneHmap = new HashMap<String, Integer>(hmap);
            for(char c : word.toCharArray()) {
                wordDict[((int) c - 'a')]++;
            }
            
            boolean flag = true;
            for(int i = 0; i < 26; i++) {
                if(wordDict[i] > 0) {
                    String s = "1-" + wordDict[i];
                    if( cloneHmap.containsKey(s) && ( cloneHmap.get(s) > 0 ) ) {
                        int count = cloneHmap.put(s, cloneHmap.get(s) - 1);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                result.add(word);
        }
        return result;
    }
}

/* Correct logic */


class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> result = new ArrayList<String>();
        Map<Character, Character> hmap;
        
        for( String word : words ) {
            hmap = new HashMap<Character, Character>();
            
            char[] c = word.toCharArray();
            boolean flag = true;
            
            for ( int i = 0; i < c.length; i++ ) {

                if ( hmap.containsKey(c[i]) ) {

                    if ( !(hmap.get(c[i]) == pattern.charAt(i)) ) {
                        flag = false;
                        break;
                    }

                } else {

                    if( hmap.containsValue( pattern.charAt(i) ) ) {
                        flag = false;
                        break;
                    }
                    
                    hmap.put( c[i], pattern.charAt(i) );
                }
            }
            
            if( flag )
                result.add( word );
        }
        
        return result;
    }
}