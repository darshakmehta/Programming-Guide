class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<Integer>();
        if(words.length == 0 || s.length() < words.length * words[0].length()) return result;
        int n = s.length();
        int m = words.length;
        int wordlistlen = words[0].length(); 
        //length of longest word in word list (note all words have same length)
        
        Map<String, Integer> hmap = new HashMap<>();
        Map<String, Integer> curMap = new HashMap<>();
        
        for(String word : words) {
            hmap.put(word, hmap.getOrDefault(word, 0) + 1);
        }
        
        String str = null, temp = null;
        
        for(int i = 0; i < wordlistlen; i++) {
            int count = 0; 
            int start = i;
            for(int j = i; j + wordlistlen <= n; j += wordlistlen) {
                str = s.substring(j, j + wordlistlen);
                if(hmap.containsKey(str)) {
                    curMap.put(str, curMap.getOrDefault(str, 0) + 1);
                    
                    if(curMap.get(str) <= hmap.get(str)) count++;
                    while(curMap.get(str) > hmap.get(str)) {
                        temp = s.substring(start, start + wordlistlen);
                        curMap.put(temp, curMap.get(temp) - 1);
                        start += wordlistlen;
                        
                        if(curMap.get(temp) < hmap.get(temp)) count--;
                    }
                    if(count == m) {
                        result.add(start);
                        temp = s.substring(start, start + wordlistlen);
                        curMap.put(temp, curMap.get(temp) - 1);
                        start += wordlistlen;
                        count--;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    start = j + wordlistlen;
                }
            }
            curMap.clear();
        }
        return result;   
    }
}