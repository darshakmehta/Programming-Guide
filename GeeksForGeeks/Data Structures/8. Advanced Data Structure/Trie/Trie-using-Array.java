class Trie {
    
    TrieNode root;
    
    class TrieNode {
        TrieNode children[];
        boolean isComplete = false;
        TrieNode() {
             children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char c[] = word.toCharArray();
        TrieNode current = root;
        for(int i = 0; i < c.length; i++) {
            if(current.children[c[i] - 'a'] == null)
                current.children[c[i] - 'a'] = new TrieNode();
            current = current.children[c[i] - 'a'] ;
        }
        current.isComplete = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char c[] = word.toCharArray();
        TrieNode current = root;
        for(int i = 0; i < c.length; i++) {
            if(current.children[c[i] - 'a'] == null)
                return false;
            current = current.children[c[i] - 'a'];
        }
        return current.isComplete;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char c[] = prefix.toCharArray();
        TrieNode current = root;
        for(int i = 0; i < c.length; i++) {
           if(current.children[c[i] - 'a'] == null)
                return false;
            current = current.children[c[i] - 'a'];
        }
       return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */