class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<List<String>>();

    Map<String, List<String>> map = new HashMap<String, List<String>>();
    /* Map<String, List<String>> Store the sorted key to each list and elements respectively */

    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String keyStr = String.valueOf(ca);

      if (!map.containsKey(keyStr))
        map.put(keyStr, new ArrayList<String>());
      map.get(keyStr).add(s);
    }
    return new ArrayList<List<String>>(map.values());
  }
}

// Similar Faster Solution because we do not get list each time, instead we just use map to get the list number

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
