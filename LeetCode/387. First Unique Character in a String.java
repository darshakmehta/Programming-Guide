class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        if(s.length() == 0)
            return -1;
        char c[] = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            int count = 1;
            if(hmap.containsKey(c[i])) {
                count = hmap.get(c[i]) + 1;
            }
            hmap.put(c[i],count);
        }
        for( int i = 0; i < c.length; i++) {
            if(hmap.get(c[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}