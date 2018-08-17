class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String,  Integer> hmap = new HashMap<String, Integer>();
        ArrayList<String> list = new ArrayList<String>();
        
        String []first = A.split(" ");
        String []second = B.split(" ");
        int count = 1;
        for(String s : first) {
            if(hmap.containsKey(s)) {
                count = hmap.get(s);
                count++;
                list.remove(s);
            } else {
                list.add(s);
            }
            hmap.put(s, count);
        }
        for(String s : second) {
            if(hmap.containsKey(s)) {
                count = hmap.get(s);
                count++;
                list.remove(s);
            } else {
                list.add(s);
            }
            hmap.put(s, count);
        }
        String []result = new String[list.size()];
        int i = 0;
        for(String s : list)
            result[i++] = s;
        
    return result;
    }
}