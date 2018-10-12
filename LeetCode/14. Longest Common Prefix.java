class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        int min = Integer.MAX_VALUE;
        for(String s: strs) {
                if(s.length() < min) {
                    min = s.length();
                }
        }
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < min; i++) {
            for(int j = 0; j < strs.length - 1; j++) {
                if(strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}

/***

TODO: https://leetcode.com/problems/longest-common-prefix/solution/ --> Read better solutions like Binary Search, Divide and Conquer, etc.

***/