class Solution {
    
    public Map<Character, Integer> sortByValue(Map<Character, Integer> hmap) {
        
        List<Map.Entry<Character, Integer> > list = 
               new LinkedList<Map.Entry<Character, Integer> >(hmap.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() { 
            public int compare(Map.Entry<Character, Integer> o1,  
                               Map.Entry<Character, Integer> o2) { 
                return (o2.getValue()).compareTo(o1.getValue()); //decreasing order
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>(); 
        for (Map.Entry<Character, Integer> entry : list) { 
            temp.put(entry.getKey(), entry.getValue()); 
        }
        return temp;
    }
    
    public String frequencySort(String s) {
        
        StringBuffer result = new StringBuffer();
        
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        
        for ( char c : s.toCharArray() ) {
            hmap.put(c, hmap.getOrDefault(c, 0) +  1);
        }
        
        Map<Character, Integer> sortedMap = sortByValue(hmap);
        
        for ( Map.Entry<Character, Integer> entry : sortedMap.entrySet() ) {
            for ( int i = 0; i < entry.getValue(); i++ ) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }
}