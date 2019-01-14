class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        Set<String> set = new HashSet<String>();
        for (String root : roots) 
            set.add(root);

        StringBuilder result = new StringBuilder();
        for ( String word: sentence.split(" ") ) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if ( set.contains(prefix) ) 
                    break;
            }
            if (result.length() > 0) 
                result.append(" ");
            result.append(prefix);
        }
        return result.toString();
    }
}

/**

root = prefix ==> Prefix ==> Trie
TODO: Use TRIE 

**/