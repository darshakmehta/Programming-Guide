class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean f[] = new boolean[len + 1];
        f[0] = true;
        /** f[i] stands for whether subarray(0, i) can be segmented into words from the dictionary.
         * So f[0] means whether subarray(0, 0) (which is an empty string) can be segmented, and of course the answer is yes.
         * The default value for boolean array is false. Therefore we need to set f[0] to be true. */
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[len];
    }
}

/**
 * Improvement : Because after you processed a few words, it is likely that the match word will be found
 * at the end of the finished part of the string, but not a really long word which begins
 * from the beginning of the string}
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean f[] = new boolean[len + 1];
        f[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[len];
    }
}

/**
 * Improvement: Add all dict words in a set.
 * Note: If you use set, you can find the element in O(1). But if you use List,you may find the element in O(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean f[] = new boolean[len + 1];
        Set<String> set = new HashSet<String>();
        for (String word: wordDict) {
            set.add(word);
        }
        // Base case
        f[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && set.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[len];
    }
}

public class Solution { // BFS Solution
    public boolean wordBreak(String s, List<String> wordDict) {
        int max_len = -1;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int start = queue.remove();
            for (int end = start + 1; end <= s.length () && end - start <= max_len; end++) {
                if (wordDictSet.contains(s.substring(start, end)) && !(end < s.length () && visited[end])) {
                    if (end == s.length()) {
                        return true;
                    }
                    queue.add(end);
                    visited[end] = true;
                }
            }
        }
        return false;
    }
}

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // DFS
        Set<Integer> set = new HashSet<Integer>();
        return dfs(s, 0, dict, set);
    }
    
    private boolean dfs(String s, int index, Set<String> dict, Set<Integer> set){
        // base case
        if(index == s.length()) return true;
        // check memory
        if(set.contains(index)) return false;
        // recursion
        for(int i = index+1;i <= s.length();i++){
            String t = s.substring(index, i);
            if(dict.contains(t))
                if(dfs(s, i, dict, set))
                    return true;
                else
                    set.add(i);
        }
        set.add(index);
        return false;
    }
}

/**
 * TODO:
 * 1. Using TRIE - leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways/43007
 * 2. DFS Solution
 * 3. Research if starting from index j = 0 is better or j = i-1
**/
