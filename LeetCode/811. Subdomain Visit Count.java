class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> hmap = new HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        
        for(String s : cpdomains) {
            String[] arr = s.split(" ");
            hmap.put(arr[1], hmap.getOrDefault(arr[1], 0) + Integer.valueOf(arr[0]));
            
            String[] dotDomains = arr[1].split("\\."); //Remember to split by dot => Use BackSlash
            
            if(dotDomains.length == 3) {
                String firstDomain = dotDomains[1] + "." + dotDomains[2];
                hmap.put(firstDomain, hmap.getOrDefault(firstDomain, 0) + Integer.valueOf(arr[0]));
                String highestLevelDomain = dotDomains[2];
                hmap.put(highestLevelDomain, hmap.getOrDefault(highestLevelDomain, 0) + Integer.valueOf(arr[0]));     
            } else {
                String highestLevelDomain = dotDomains[1];
                hmap.put(highestLevelDomain, hmap.getOrDefault(highestLevelDomain, 0) + Integer.valueOf(arr[0]));     
            }
            
        }
        
        for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
            String s = entry.getValue() + " " + entry.getKey();
            result.add(s);
        }
        
        return result;
    }
}