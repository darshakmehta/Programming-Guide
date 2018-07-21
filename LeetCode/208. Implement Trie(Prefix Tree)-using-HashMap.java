class Trie {
    
    TrieNode root;
    
    class TrieNode {
        HashMap<Character, TrieNode> children = null;
        boolean isComplete = false;
        public char val;
        TrieNode() {
            
        }
        TrieNode(char val) {
            this.val = val;
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
            if(current.children == null)
                current.children = new HashMap<Character, TrieNode>();
            if(!current.children.containsKey(c[i]))
                current.children.put(c[i], new TrieNode(c[i]));
            current = current.children.get(c[i]);
        }
        current.isComplete = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char c[] = word.toCharArray();
        TrieNode current = root;
        boolean flag = false;
        for(int i = 0; i < c.length; i++) {
            if(current.children == null || !current.children.containsKey(c[i]))
                return false;
            current = current.children.get(c[i]);
        }
        return current.isComplete;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char c[] = prefix.toCharArray();
        TrieNode current = root;
        boolean flag = false;
        for(int i = 0; i < c.length; i++) {
            if(current.children == null || !current.children.containsKey(c[i]))
                return false;
            current = current.children.get(c[i]);
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