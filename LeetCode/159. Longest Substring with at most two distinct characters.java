class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        hMap<Character,Integer> hmap = new HashhMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
            if(hmap.get(c) == 1) counter++;//new char
            end++;

            while(counter > 2){ // can be easily replaced by k distinct characters
                char cTemp = s.charAt(start);
                hmap.put(cTemp, hmap.get(cTemp) - 1);
                if(hmap.get(cTemp) == 0){
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }
}