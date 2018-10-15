class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if(t.length() > s.length()) return result;
        
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for(char c : t.toCharArray()) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        
        int begin = 0, end = 0;
        int counter = hmap.size();
        int minLen = Integer.MAX_VALUE, minStart = 0;
        
        while(end < s.length()) {
            char c = s.charAt(end);
            if(hmap.containsKey(c)) {
                hmap.put(c, hmap.get(c) - 1);
                if(hmap.get(c) == 0) counter--;
            }
            
            end++;
            
            while(counter == 0) {
                if(end - begin < minLen) {
                    minStart = begin;
                    minLen = end - begin;
                }
                
                char tempc = s.charAt(begin);
                
                if(hmap.containsKey(tempc)) {
                    hmap.put(tempc, hmap.get(tempc) + 1);
                    if(hmap.get(tempc) > 0) counter++;
                }
                
                
                begin++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen); 
    }
}