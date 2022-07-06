class Solution { // Time: O(n^2)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        char[] arr = s.toCharArray();
        int maxLen = Integer.MIN_VALUE;
        int currLen = 0;
        int firstCharAt = 0;

        if (arr.length == 0) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!hmap.containsKey(arr[i])) {
                hmap.put(arr[i], i);
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                int lastFoundAt = hmap.get(arr[i]);
                currLen = i - lastFoundAt;
                for (int k = lastFoundAt; k >= firstCharAt; k--) {
                    hmap.remove(arr[k]);
                }
                firstCharAt = lastFoundAt + 1;
                hmap.put(arr[i], i);
            }
        }
        return maxLen;
    }
}
