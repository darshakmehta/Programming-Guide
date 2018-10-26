class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean f[] = new boolean[s.length() + 1];
        f[0] = true;
        /* f[i] stands for whether subarray(0, i) can be segmented into words from the dictionary. So f[0] means whether subarray(0, 0) (which is an empty string) can be segmented, and of course the answer is yes. The default value for boolean array is false. Therefore we need to set f[0] to be true. */
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) { //TODO: int j = i - 1; j >= 0; j-- {improvement : Because after you processed a few words, it is likely that the match word will be found at the end of the finished part of the string, but not a really long word which begins from the beginning of the string}
                if(f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}

public class Solution { //BFS Solution
    public boolean wordBreak(String s, List<String> wordDict) {
        int max_len = -1;
        for (String word : wordDict)
            max_len = Math.max (max_len, word.length ());
        Set<String> wordDictSet=new HashSet(wordDict);
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

/***

TODO:
1. Using TRIE - leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways/43007
2. Add all dict words in set  ==> If you use set, you can find the element in O(1).But if you use List,you may find the element in O(n)
3. BFS solution
4. DFS Solution

Complexity Analysis:
just want to add some comments for the time complexity:
First DP: [length of s][size of dict][avg length of words in dict]
Second DP: [length of s]^3

BTW, for this kind of problem, which time complexity is [length of s][size of dict][avg length of words in dict]. We can usually remove [size of dict] by using Tire, remove [avg length of words in dict] by KMP, and what's more, remove both [size of dict] and [avg length of words in dict] by AC-automata. And of course these are all doable for this problem.
This is just a insight for people who want to think deeper about this problem, hope it can help you :)


***/