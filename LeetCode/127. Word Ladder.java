class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        
        if (!dict.contains(endWord))
          return 0;
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int size = queue.size();
        int level = 1;
        while (!queue.isEmpty()) {
          String w = queue.poll();
          size--;

          for (int i = 0; i < w.length(); i++) {
            char[] a = w.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
              a[i] = j;
              String newOne = new String(a);
              if (newOne.equals(endWord))
                return level + 1;
              if (dict.contains(newOne)) {
                queue.add(newOne);
                dict.remove(newOne);
              }
            }
          }
          if (size == 0) {
            size = queue.size();
            level++;
          }
        }
        return 0;
      }
}