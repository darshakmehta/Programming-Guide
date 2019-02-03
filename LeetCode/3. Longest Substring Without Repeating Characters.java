class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int begin = 0, end = 0;
        int counter = 0;
        if(s.length() == 0) return result;
        
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        while(end < s.length()) {
            char c = s.charAt(end);
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
            
            if(hmap.get(c) > 1) counter++;
            end++;
            
            while(counter > 0) {
                char tempc = s.charAt(begin);
                if(hmap.get(tempc) > 1) counter--;
                hmap.put(tempc, hmap.get(tempc) - 1);
                begin++;
            }
            result = Math.max(result, end - begin);
        }
        
        return result; 
    }
}