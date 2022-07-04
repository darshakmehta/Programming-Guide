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

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int smallestStrLen = Integer.MAX_VALUE;
        String smallestStr = "";

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < smallestStrLen) {
                smallestStrLen = strs[i].length();
                smallestStr = strs[i];
            }
        }

        StringBuilder result = new StringBuilder();

        for (int k = 0; k < smallestStr.length(); k++) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(k) != smallestStr.charAt(k)) { // faster since we compare with smallest possible prefix.
                    return result.toString();
                }
            }
            result.append(smallestStr.charAt(k));
        }
        return result.toString();
    }
}


/***

TODO: https://leetcode.com/problems/longest-common-prefix/solution/ --> Read better solutions like Binary Search, Divide and Conquer, etc.

***/
