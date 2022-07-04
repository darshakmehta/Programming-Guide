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
                if (strs[i].charAt(k) != smallestStr.charAt(k)) {
                    return result.toString();
                }
            }
            result.append(smallestStr.charAt(k));
        }
        return result.toString();
    }
}
