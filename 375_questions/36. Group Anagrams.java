class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> hmap = new HashMap<String, Integer>();
        List<List<String>> list = new ArrayList<List<String>>();
        int index = 0;

        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);

            String str = String.valueOf(tmp);

            if (!hmap.containsKey(str)) {
                hmap.put(str, index++);
                List<String> l = new ArrayList<String>();
                l.add(strs[i]);
                list.add(l);
            } else {
                List<String> tmpList = list.get(hmap.get(str));
                tmpList.add(strs[i]);
            }
        }

        return list;
    }
}
