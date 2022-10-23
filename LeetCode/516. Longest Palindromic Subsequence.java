class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int diff = 0; diff < len; diff++) {
            for (int i = 0, j = i + diff; j < len; i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (diff == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}
