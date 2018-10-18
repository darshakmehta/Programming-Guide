class Solution { //O(nlogn)
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        
        for(int i : nums) hmap.put(i, hmap.getOrDefault(i, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>> (hmap.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            } 
        });
        
        HashMap<Integer, Integer> resultHmap = new LinkedHashMap<Integer, Integer>();
        
        for(Map.Entry<Integer, Integer> pair: list) resultHmap.put(pair.getKey(), pair.getValue());
        
        Iterator iter = resultHmap.entrySet().iterator();
        int i = 0;
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            resultList.add((Integer) pair.getKey());
            i++;
            if(i == k) {
                break;
            }
        }
        return resultList;
    }
}

class Solution { //O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i : nums) hmap.put(i, hmap.getOrDefault(i, 0) + 1);
        
        List<Integer> []bucket = new List[nums.length + 1];
        
        for(int key : hmap.keySet()) {
            int frequency = hmap.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<Integer>();
            }
            bucket[frequency].add(key);
        }
        
        List<Integer> resultList = new ArrayList<Integer>();
        
        for(int pos = bucket.length - 1; pos >= 0 && resultList.size() < k; pos--) {
            if(bucket[pos] != null) {
                resultList.addAll(bucket[pos]);
            }
        }
        
        return resultList;
    }
}


/*

TODO:

1. Solve using MinHeap. leetcode.com/problems/top-k-frequent-elements/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap/158484
2. Solve using TreeMap
3. Solve using Selection Sort

*/