/**
 * Problem Link: 49. https://leetcode.com/problems/group-anagrams/
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String s: strs) {
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String sortedStr = String.valueOf(cArr);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<String>());
            }
            map.get(sortedStr).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }
}

/**
 * Note: Fetching list each time is costly, rather we can start building the result list
 * and store count of the list with the key in the hashmap.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> hmap = new HashMap<String, Integer>();
        List<List<String>> result = new ArrayList<List<String>>();
        int count = 0;

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);

            if (hmap.containsKey(str)) {
                List<String> list = result.get(hmap.get(str));
                list.add(s);
            } else {
                hmap.put(str, count);
                List<String> list = new ArrayList<String>();
                list.add(s);
                result.add(list);
                count++;
            }
        }

        return result;
    }
}
