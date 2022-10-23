/**
 * 2-DP Solution
 */
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        int start = 0;
        int end = 0;

        // to traverse diagonally
        for (int diff = 0; diff < len; diff++) {
            for (int i = 0, j = i + diff; j < len; i++, j++) {
                // single character - palindrome
                if (i == j) {
                    dp[i][j] = 1;
                }
                // if both characters are same - palindrome
                else if (diff == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 0;
                }
                // if diff > 1 - check outside characters match and if innner string is palindrome
                else {
                    if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]>0) {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                }

                // if we found a palindromic substring, update start and end
                if (dp[i][j] != 0 && (diff > (end - start))) {
                    start = i;
                    end = i + diff;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}

/**
 * Extend around middle
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0; // use to find the substring

        for (int i = 0; i < s.length(); i++) {
            int len1 = extendPalindrome(s, i, i);
            int len2 = extendPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
