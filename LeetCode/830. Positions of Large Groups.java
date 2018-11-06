class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i <= S.length(); i++) { //For every character starting from 2nd character
            if (i == S.length() || S.charAt(i) != S.charAt(start)) { //If characters are same increment else check the length of consecutive
                if (i - start >= 3) { //If 3 or more consecutive characters found
                    result.add(Arrays.asList(start, i - 1)); //Add to the arrayList
                }
                start = i; //Re assign the unmatched character index as start
            }
        }
        return result;
    }
}