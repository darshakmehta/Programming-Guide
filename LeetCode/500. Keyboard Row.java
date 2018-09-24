class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        List<String> list = new ArrayList<String>();

        hmap.put('q', 1);hmap.put('w', 1);hmap.put('e', 1);hmap.put('r', 1);hmap.put('t', 1);hmap.put('y', 1);hmap.put('u', 1);hmap.put('i', 1);hmap.put('o', 1);hmap.put('p', 1);
        hmap.put('a', 2);hmap.put('s', 2);hmap.put('d', 2);hmap.put('f', 2);hmap.put('g', 2);hmap.put('h', 2);hmap.put('j', 2);hmap.put('k', 2);hmap.put('l', 2);
        hmap.put('z', 3);hmap.put('x', 3);hmap.put('c', 3);hmap.put('v', 3);hmap.put('b', 3);hmap.put('n', 3);hmap.put('m', 3);
        
        
        for(String s : words) {
            s = s.toLowerCase();
            char []c = s.toCharArray();
            int checker = hmap.get(c[0]);
            boolean flag = true;
            for(int i = 0; i < c.length; i++) {
                if(hmap.get(c[i]) != checker) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                list.add(s);
        }
        
        String []result = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}