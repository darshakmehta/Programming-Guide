class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) return false;

        Map<Character,Integer> hmap = new HashMap<>();
        char[] ch=s1.toCharArray();
        
        for(char c : ch)
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        
        int count=hmap.size();
        int start=0, end=0;
        
        while (end < s2.length()) {
            char tempc = s2.charAt(end);
            if (hmap.containsKey(tempc)){
                hmap.put(tempc, hmap.get(tempc) - 1);
                if (hmap.get(tempc)==0) count--;
            }
            end++;

            while (count == 0){
                tempc=s2.charAt(start);
                if (hmap.containsKey(tempc)){
                    hmap.put(tempc, hmap.get(tempc) + 1);
                    if (hmap.get(tempc)>0) count++;   
                }
                if(end - start == s1.length()) return true;
                start++;
            } 
        }
        return false;
    }
}