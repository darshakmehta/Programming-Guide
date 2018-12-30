class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<String>();
        Map<String, Integer> hmap = new HashMap<String, Integer>();
        
        paragraph = paragraph.replaceAll("[!?',;\\.]", " ");
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9 -]", "");
        
        for ( String bannedWord : banned ) {
            bannedWords.add(bannedWord);
        }
        
        String result = null;
        
        for( String word : paragraph.toLowerCase().split("\\s+") ) {
            if( !bannedWords.contains(word )) {
                hmap.put( word, hmap.getOrDefault( word, 0 ) + 1 );
                if( result == null ) result = new String(word);
                if ( hmap.get(result) < hmap.get(word) ) {
                    result = new String(word);
                }
            }
        }
        
        return result;
    }
}