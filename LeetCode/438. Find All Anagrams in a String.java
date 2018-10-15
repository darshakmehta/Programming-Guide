class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list = new ArrayList<Integer>();
        if(p.length() > s.length()) return list;
        
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for(char c : p.toCharArray()) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        
        int begin = 0, end = 0;
        int counter = hmap.size();
        
        while(end < s.length()) {
            char c = s.charAt(end);
            if(hmap.containsKey(c)) {
                hmap.put(c, hmap.get(c) - 1);
                if(hmap.get(c) == 0) counter--;
            }
            
            end++;
            
            while(counter == 0) {
                char tempc = s.charAt(begin);
                
                if(hmap.containsKey(tempc)) {
                    hmap.put(tempc, hmap.get(tempc) + 1);
                    if(hmap.get(tempc) > 0) counter++;
                }
                
                if(end - begin == p.length()) {
                    list.add(begin);
                }
                begin++;
            }
        }
        
        return list;
    }
}

class Solution { //TLE
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list = new ArrayList<Integer>();
        if(s.length() == 0) return list;
        char ch[] = p.toCharArray();
        Arrays.sort(ch);
        String secondStr = String.valueOf(ch);
        int l1 = s.length();
        int l2 = p.length();
        for(int i = 0; i <= l1 - l2; i++) {
            String subStr = s.substring(i, i + l2);
            ch = subStr.toCharArray();
            Arrays.sort(ch);
            String firstStr = String.valueOf(ch);
            //System.out.println("1: " + firstStr + " 2: " + secondStr);
            if(firstStr.equals(secondStr)) list.add(i);
        }
        
        return list;
    }
}