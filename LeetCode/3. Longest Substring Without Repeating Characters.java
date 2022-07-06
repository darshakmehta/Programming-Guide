class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int begin = 0, end = 0;
        int counter = 0;
        if(s.length() == 0) return result;

        Map<Character, Integer> hmap = new HashMap<Character, Integer>();

        while (end < s.length()) {
            char c = s.charAt(end);
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);

            if (hmap.get(c) > 1) counter++;
            end++;

            while (counter > 0) {
                char tempc = s.charAt(begin);
                if(hmap.get(tempc) > 1) counter--;
                hmap.put(tempc, hmap.get(tempc) - 1);
                begin++;
            }
            result = Math.max(result, end - begin);
        }

        return result;
    }
}

class Solution { // Time: O(2n)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        char[] arr = s.toCharArray();
        int maxLen = Integer.MIN_VALUE;
        int currLen = 0;
        int firstCharAt = 0;

        if (arr.length == 0) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) { // O(n)
            if (!hmap.containsKey(arr[i])) {
                hmap.put(arr[i], i);
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                int lastFoundAt = hmap.get(arr[i]);
                currLen = i - lastFoundAt;
                for (int k = lastFoundAt; k >= firstCharAt; k--) { // Max time would be visiting every character once more.
                    hmap.remove(arr[k]);
                }
                firstCharAt = lastFoundAt + 1;
                hmap.put(arr[i], i);
            }
        }
        return maxLen;
    }
}
