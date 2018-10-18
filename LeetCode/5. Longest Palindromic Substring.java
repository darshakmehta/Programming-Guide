class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";    
        int start = 0, end = 0; // use to find the substring

        for(int i = 0; i < s.length(); i++) {
            int len1 = extendPalindrome(s, i, i);
            int len2 = extendPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    public int extendPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}