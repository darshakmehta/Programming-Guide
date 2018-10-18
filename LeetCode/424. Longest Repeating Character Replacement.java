class Solution {
      public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        int start = 0, end = 0, counter = 0, result = 0;

        Map<Character, Integer> hmap = new HashMap<>();

        while(end < s.length()) {
            char c = s.charAt(end++);
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);

            if (counter < hmap.get(c)) counter = hmap.get(c);
            
            while(!(end - start - counter <= k)) {
                char temp = s.charAt(start);
                hmap.put(temp, hmap.get(temp) - 1);
                counter = getMax(hmap);
                start++;
            }
            result = Math.max(result, end - start);
        }       
        return result;
    }
    
    private int getMax(Map<Character, Integer> hmap) {
        int max = 0;
        for(int freq : hmap.values()) {
            max = Math.max(max, freq);
        }
        return max;
    }
}

/***

TODO: Convert HashMap to integer array

***/