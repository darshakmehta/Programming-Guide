class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> hmap = new LinkedHashMap<Character, Integer>();
        if(s.length() == 0)
            return -1;
        char c[] = s.toCharArray();
        int a[] = new int[s.length()];
        for(int i = 0; i < c.length; i++) {
            int count = 1;
            if(hmap.containsKey(c[i])) {
                count = hmap.get(c[i]);
                count++;
            }
            hmap.put(c[i],count);
            a[i] = count;
            //System.out.println(c[i] + " " + a[i] + " " + i);
        }
        for( int i = 0; i < c.length; i++) {
            if(hmap.get(c[i]) == 1) {
                return i;
            }
        }
        return -1;
        
        
    }
}